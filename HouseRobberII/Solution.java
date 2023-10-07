package LeetCode.HouseRobberII;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1){return nums[0];}
        if (nums.length == 2){return Integer.max(nums[0], nums[1]);}
        int [] nums2 = new int[nums.length-1];
        int [] nums3 = new int[nums.length-1];
        for (int i=0; i<nums2.length; i++){
            nums2[i] = nums[i+1];
        }
        for (int i=0; i<nums3.length; i++){
            nums3[i] = nums[i];
        }
        int ans1 = solve(nums);
        int ans2 = solve(nums2);
        int ans3 = solve(nums3);
        if (ans1 > ans2 && ans1 > ans3){
            return Integer.max(ans2, ans3);
        }
        return ans1;
    }
    int solve(int [] nums){
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
        return ans[ans.length-1];
    }
}
