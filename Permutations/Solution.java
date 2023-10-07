package LeetCode.Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    boolean[] b = new boolean[20];
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }
    void backtrack(List<List<Integer>>list, List<Integer> tempList, int [] nums){
        if (tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        }
        else {
            for (int i=0; i<nums.length; i++){
                if (b[nums[i]+10] == false){
                    tempList.add(nums[i]);
                    b[nums[i]+10] = true;
                    backtrack(list, tempList, nums);
                    b[nums[i]+10] = false;
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }
}
