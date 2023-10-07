package LeetCode.MaximumSubarray;

public class maxSumSubarray {
    public static void main(String[] args) {
        int [] a = {-2,1,-3,4,-1,2,1,-5,4};
        int ans = new Solution().maxSubArray(a);
        System.out.println(ans);
    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int [] d = new int[n];
        d[0] = nums[0];
        for (int i=1; i<n; i++){
            if (d[i-1] + nums[i] > nums[i]){
                d[i] = d[i-1] + nums[i];
            }
            else {
                d[i] = nums[i];
            }
        }
        int ret = d[0];
        for (int i=0; i<n; i++){
            if (ret < d[i]){ret = d[i];}
            System.out.print(d[i] + " ");
        }
        System.out.println();
        return ret;
    }
}