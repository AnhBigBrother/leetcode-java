public class Solution {
    public int findMin(int[] nums) {
        int ans = nums[0];
        int l=1;
        int r = nums.length-1;
        while (l <= r){
            int m = (l+r)/2;
            if (nums[l] < ans){ans = nums[l];}
            if (nums[r] < ans){ans = nums[r];}
            if (nums[m] < ans){ans = nums[m];}
            if (nums[l] == nums[r]){ // nothing can do
                l++;
                r--;
            }
            else if (nums[l] > nums[r]){ // the array has been rotated
                if (nums[m] <= nums[r]){ // the right part is in ascending order, but the left part is not.
                    l++;
                    r = m-1;
                }
                else { // the left part is in ascending order, but the right part is not.
                    r--;
                    l = m+1;
                }
            }
            else { // The array has not been rotated, the first element is the minimum element
                return ans;
            }
        }
        return ans;
    }
}
class run {
    public static void main(String[] args) {
        int [] nums = {3,1,3,3};
        System.out.println(new Solution().findMin(nums));
    }
}