package LeetCode.twoSumjava;

import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target  = 6;
        int [] out = new Solution().twoSum(nums, target);
        System.out.println(out[0] + " " + out[1]);
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            if (!m.containsKey(nums[i])){m.put(target-nums[i], i);}
            else {
                ans[0] = m.get(nums[i]);
                ans[1] = i;
                return ans;
            }
        }
        return ans;
    }
}
