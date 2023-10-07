package LeetCode.HouseRobber;

public class Solution {
    public int rob(int[] nums) {
        int [] ans = new int[nums.length];
        ans [0] = nums[0];
        if (nums.length > 1){
            ans[1] = Integer.max(nums[0], nums[1]);
        }
        for (int i=2; i<nums.length; i++){
            ans[i] = Integer.max(ans[i-1], ans[i-2] + nums[i]);
        }
        for (int i=0; i<nums.length; i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();
        return ans[nums.length-1];
    }
}
