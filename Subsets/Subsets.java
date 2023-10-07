package LeetCode.Subsets;

import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,2,2,2,2,2,3,3,3,3,3,4,5};
        List<List<Integer>> ans = new Solution().subsets(nums);
        for (int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
}
