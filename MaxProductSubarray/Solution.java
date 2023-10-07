package LeetCode.MaxProductSubarray;

public class Solution {
    public int maxProduct(int[] nums) {
        int [] maxPro = new int[nums.length];
        int [] minPro = new int[nums.length];
        maxPro[0] = nums[0];
        minPro[0] = nums[0];
        for (int i=1; i<nums.length; i++){
            if (nums[i] > 0){
                maxPro[i] = Integer.max(nums[i], nums[i]*maxPro[i-1]);
                minPro[i] = Integer.min(nums[i], nums[i]*minPro[i-1]);
            }
            else if (nums[i] < 0){
                maxPro[i] = Integer.max(nums[i], nums[i]*minPro[i-1]);
                minPro[i] = Integer.min(nums[i], nums[i]*maxPro[i-1]);
            }
            else {
                maxPro[i] = 0;
                minPro[i] = 0;
            }
        }
        int ans = maxPro[0];
        for (int i : maxPro){
            if (i > ans){
                ans = i;
            }
        }
        return ans;
    }
}
