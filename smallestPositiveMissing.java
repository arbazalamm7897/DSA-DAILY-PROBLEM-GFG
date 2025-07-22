import java.util.*;
class smallestPositiveMissing {
    public int missingNumber(int[] arr) {
        // code here
        Arrays.sort(arr);
        int max = arr[arr.length-1];
        if(max < 1){
            return 1;
        }
        for(int i=1; i<=max; i++){
            boolean found = false;
            for(int num : arr){
                if(num==i){
                    found = true;
                    break;
                }
            }
            if(!found){
                return i;
            }
        }
        return max+1;
    }
}
