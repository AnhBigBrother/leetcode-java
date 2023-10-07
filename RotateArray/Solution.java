package LeetCode.RotateArray;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void rotate(int[] nums, int k) {
        Queue <Integer> q = new LinkedList<>();
        for (int i=nums.length-1; i >= 0; i--){
            q.offer(nums[i]);
        }
        while (k > 0){
            int x = q.poll();
            q.offer(x);
            k--;
        }
        for (int i=nums.length-1; i >= 0; i--){
            nums[i] = q.poll();
        }
    }
}
