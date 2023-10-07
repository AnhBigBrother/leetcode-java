package LeetCode.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int s = 0;
        List<Integer> l = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backTrack(candidates, target, l, s, 0, 0);
        return ans;
    }
    void backTrack(int[] candidates, int target, List<Integer> l, int s, int p, int j){
        for (int i=p; i<candidates.length; i++){
            if (candidates[i] != j){
                s += candidates[i];
                l.add(candidates[i]);
                if ( s == target){
                    ans.add(new ArrayList<>(l));
                }
                else if ( s < target ){
                    backTrack(candidates, target, l, s, i+1, 0);
                }
                s -= candidates[i];
                l.remove(l.size()-1);
                j = candidates[i];
            }
        }
    }
}
