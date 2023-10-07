package LeetCode.MinInRotatedSortedArray;

public class Solution {
    public int findMin(int[] nums) {
        return search(nums, 0, nums.length-1);
    }
    int search(int [] nums, int l, int r){
        if (l == r){return nums[l];}
        if (l == r-1 ){
            if (nums[l] > nums[r]) {return nums[r];}
            else {return nums[l];}
        }
        int m = (l+r)/2;
        if (nums[m] > nums[l] && nums[m] < nums[r]){
            return search(nums, l, m);
        }
        else if (nums[m] < nums[l] && nums[m] < nums[r]){
            return search(nums, l, m);
        }
        else if (nums[m] > nums[l] && nums[m] > nums[r]){
            return search(nums, m, r);
        }
        return 0;
    }
}
class run{
    public static void main(String[] args) {
        int [] nums = {3,4,5,1,2};
        System.out.println(new Solution().findMin(nums));
    }
}