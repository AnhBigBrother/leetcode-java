package LeetCode.Permutations;

import java.util.List;

public class Entry {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        List<List<Integer>> ans = new Solution().permute(nums);
        for (int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
}
