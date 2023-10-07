package LeetCode.CombinationSum;

import java.util.List;

public class Entry {
    public static void main(String[] args) {
        int [] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> ans = new Solution().combinationSum(candidates, target);
        for (int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
}
