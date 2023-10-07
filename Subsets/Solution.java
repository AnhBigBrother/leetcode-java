package LeetCode.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        List<Integer> l = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans, l, nums, 0);
        return ans;
    }
    void backtrack(List<List<Integer>> ans, List<Integer> l, int[] nums, int p){
        for (int i=p; i<nums.length; i++){
            l.add(nums[i]);
            ans.add(new ArrayList<>(l));
            backtrack(ans, l, nums, i+1);
            l.remove(l.size()-1);
            while (i+1 < nums.length && nums[i+1] == nums[i]){i++;}
        }
    }
    int ans = 0;
    public int combinationSum4(int[] nums, int target) {
        backtrack(nums, target, 0, new ArrayList<>());
        return ans;
    }
    void backtrack(int[] nums, int target, int s, List<Integer> a){
        if (s == target){
            ans++;
            System.out.println(a);
        }
        if (s >= target){return;}
        for (int i=0; i<nums.length; i++){
            s += nums[i];
            a.add(nums[i]);
            backtrack(nums, target, s, new ArrayList<>(a));
        }
    }
}
class run{
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        System.out.println(new Solution().combinationSum4(nums, 4));
    }
}
