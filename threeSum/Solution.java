package LeetCode.threeSum;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

// 2 Pointers - O(n^2)

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length -2; i++){
            int l = i+1;
            int r = nums.length-1;
            while (l < r){
                int s = nums[i] + nums[l] + nums[r];
                if (s > 0){
                    r--;
                }
                else if (s < 0){
                    l++;
                }
                else {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
