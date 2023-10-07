package LeetCode.threeSum;

import java.util.List;

public class threeSum {
    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = new Solution().threeSum(nums);
        for (int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
}
