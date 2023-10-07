package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int  target = 2;
        System.out.println(Solution.search(nums, target));
    }
}
class Solution {
    public static int bise(int[] nums, int target, int l, int r){
        if (target == nums[l]) {return l;}
        else if (target == nums[r]) {return r;}
        int m = (l + r)/2;
        if (r == l+2 && nums[l] != target && nums[m] != target && nums[r] != target){return -1;} 
        if (target > nums[m]){return bise(nums, target, m, r);}
        else if (target < nums[m]){return bise(nums, target, l, m);}
        else {return m;}
    }
    public static int search(int[] nums, int target) {
        if (nums.length == 1){
            if (nums[0] == target) {return 0;}
            else {return -1;}
        }
        else if (nums.length == 2){
            if (nums[0] == target) {return 0;}
            else if (nums[1] == target) {return 1;}
            else {return -1;}
        }
        else if (nums.length == 3){
            if (nums[0] == target) {return 0;}
            else if (nums[1] == target) {return 1;}
            else if (nums[2] == target) {return 2;}
            else {return -1;}
        }
        return bise(nums, target, 0, nums.length-1);
    }
}
