package LeetCode.SearchInRotatedSortedArray;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums[0] < nums[nums.length-1]){return solve1(nums, target, 0, nums.length-1);}
        return solve2(nums, target, 0, nums.length-1);
    }
    int solve1(int[] nums, int target, int l, int r){
        int m = (l+r)/2;
        if (nums[l] == target){return l;}
        if (nums[r] == target){return r;}
        if (nums[m] == target){return m;}
        if (l >= r){return -1;}
        if (nums[m] > target && target > nums[l]){
            return solve1(nums, target, l+1, m-1);
        }
        else if (nums[m] < target && target < nums[r]){
            return solve1(nums, target, m+1, r-1);
        }
        return -1;
    }
    int solve2 (int[] nums, int target, int l, int r){
        int m = (l+r)/2;
        if (nums[l] == target){return l;}
        if (nums[r] == target){return r;}
        if (nums[m] == target){return m;}
        if (l >= r){return -1;}
        if (nums[m] < nums[l]){
            if (target > nums[m] && target < nums[r]){
                return solve1(nums, target, m+1, r-1);
            }
            else if (target > nums[l] || target < nums[m]){
                return solve2(nums, target, l+1, m-1);
            }
        }
        else {
            if (target > nums[l] && target < nums[m]){
                return solve1(nums, target, l+1, m-1);
            }
            else if (target > nums[m] || target < nums[r]){
                return solve2(nums, target, m+1, r-1);
            }
        }
        return -1;
    }
}
