package LeetCode.RotateArray;

public class Entry {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        new Solution().rotate(nums, 3);
        for (int x : nums){
            System.out.print(x + " ");
        }
    }
}
