public class countTheCoprime {
   static final int MAX = 10001;

    public int cntCoprime(int[] arr) {
        int n = arr.length;
        int[] freq = new int[MAX];

        // Step 1: Count frequency of each number
        for (int num : arr) {
            freq[num]++;
        }

        // Step 2: Count how many numbers are divisible by i
        int[] divCount = new int[MAX];
        for (int i = 1; i < MAX; i++) {
            for (int j = i; j < MAX; j += i) {
                divCount[i] += freq[j];
            }
        }

        // Step 3: Compute Möbius function
        int[] mobius = computeMobius(MAX);

        // Step 4: Count total coprime pairs using inclusion-exclusion
        int totalCoprimePairs = 0;
        for (int i = 1; i < MAX; i++) {
            int count = divCount[i];
            if (count >= 2) {
                int pairs = (count * (count - 1)) / 2;
                totalCoprimePairs += mobius[i] * pairs;
            }
        }

        return totalCoprimePairs;
    }

    // Möbius Function using Sieve
    private int[] computeMobius(int n) {
        int[] mobius = new int[n];
        for (int i = 0; i < n; i++) mobius[i] = 1;

        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                for (int j = i; j < n; j += i) {
                    isPrime[j] = true;
                    mobius[j] *= -1;
                }
                for (int j = i * i; j < n; j += i * i) {
                    mobius[j] = 0;
                }
            }
        }

        return mobius;
    }
}
