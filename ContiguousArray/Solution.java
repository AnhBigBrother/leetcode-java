package LeetCode.ContiguousArray;

import java.util.HashMap;

public class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int [] zero = new int [n+1]; // number of 0 at position i
        int [] one = new int [n+1]; // number of 1 at position i
        for (int i=0 ; i<n; i++){
            if (nums[i] == 0){
                zero[i+1] = zero[i] + 1;
                one[i+1] = one[i];
            }
            else{
                zero[i+1] = zero[i];
                one[i+1] = one[i]+1;
            }
        }
        int [] onzo = new int[n+1]; // one[i] - zero[i]
        for (int i=1; i<=n; i++){
            onzo[i] = one[i] - zero[i];
        }
        // for (int i : onzo){
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        HashMap<Integer,Integer> first = new HashMap<>();
        int maxLength = 0;
        for (int i=0; i<n+1; i++){
            if (!first.containsKey(onzo[i])){
                first.put(onzo[i], i);
            }
            if (i - first.get(onzo[i]) > maxLength){
                maxLength = i - first.get(onzo[i]);
            }
        }
        return maxLength;
    }
}
class Entry {
    public static void main(String[] args) {
        int [] nums = {1,0,1,1,1,0,0};
        System.out.println(new Solution().findMaxLength(nums));
    }
}