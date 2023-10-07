package LeetCode.LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int i : nums){
            visited.put(i , false);
        }
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i : nums){
            if (visited.get(i) == false){
                visited.put(i, true);
                q.offer(i);
                int n = 1;
                while (!q.isEmpty()){
                    int x = q.poll();
                    if (visited.containsKey(x-1) && visited.get(x-1) == false){
                        visited.put(x-1, true);
                        q.offer(x-1);
                        n++;
                    }
                    if (visited.containsKey(x+1) && visited.get(x+1) == false){
                        visited.put(x+1, true);
                        q.offer(x+1);
                        n++;
                    }
                }
                if (n > ans){ans = n;}
            }
        }
        return ans;
    }
}
