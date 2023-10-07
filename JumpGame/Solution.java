package LeetCode.JumpGame;

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int [] canJumpTo = new int[n];
        canJumpTo[0] = nums[0];
        for (int i=1; i<n; i++){
            if (canJumpTo[i-1] < i){return false;}
            else {
                canJumpTo[i] = i + nums[i] > canJumpTo[i-1] ? i+nums[i] : canJumpTo[i-1];
            }
            if (canJumpTo[i] >= n-1){return true;}
        }
        return true;
    }
}
class Entry{
    public static void main(String[] args) {
        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        System.out.println(new Solution().canJump(nums1));
        System.out.println(new Solution().canJump(nums2));
    }
}
