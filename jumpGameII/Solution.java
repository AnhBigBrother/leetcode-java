package LeetCode.jumpGameII;

public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxlev = nums[0];
        int level = 0;
        int count = 0;
        for (int i=1; i<n; i++){
            if (i-1 == level){
                level = maxlev;
                count ++;
            }
            if (maxlev < i+nums[i]){
                maxlev = i+nums[i];
            }
        }
        return count;
    }
}
class run {
    public static void main(String[] args) {
        int [] nums = {2,3,1,1,4};
        System.out.println(new Solution().jump(nums));
    }
}