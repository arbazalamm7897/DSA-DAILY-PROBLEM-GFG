package gfg;

import java.util.*;

class CountNumbersContainingSpecificEffect {
    public int countValid(int n, int[] arr) {
        Set<Integer> allowed = new HashSet<>();
        for (int digit : arr) {
            allowed.add(digit);
        }

        // Step 1: Total n-digit numbers
        int total = 9 * (int)Math.pow(10, n - 1);

        // Step 2: Digits not in arr[]
        List<Integer> notAllowed = new ArrayList<>();
        for (int d = 0; d <= 9; d++) {
            if (!allowed.contains(d)) {
                notAllowed.add(d);
            }
        }

        int k = notAllowed.size();
        if (k == 0) return total; // All digits are allowed → return total
        if (k == 10) return 0;    // None of arr[] is allowed → 0 valid numbers

        // Step 3: Count how many n-digit numbers can be made using only notAllowed
        int count = 0;
        for (int d : notAllowed) {
            if (d == 0) continue; // first digit can't be 0
            count += Math.pow(k, n - 1);
        }

        // Step 4: Valid = total - invalid
        return total - count;
    }
}
