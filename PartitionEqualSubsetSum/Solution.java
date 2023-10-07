package LeetCode.PartitionEqualSubsetSum;

import java.util.Arrays;

public class Solution {
    public boolean canPartition(int[] nums) {
        int s = 0;
        for (Integer i : nums){
            s += i;
        }
        if (s % 2 == 1){return false;}
        s /= 2;
        Arrays.sort(nums);
        boolean [] b = new boolean[s+1];
        b[0] = true;
        // This solution is a other varian of dynamic programming
        for (Integer i : nums){
            if (i > s){break;}
            for (int k = s; k>=i; k--){
                // k back from high val to low val 
                // avoid the faul b[i]=true, b[2i]=true, 3i,4i, ...
                b[k] = (b[k] || b[k-i]);
            }
        }
        return b[s];
    }
}