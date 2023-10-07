package LeetCode.DistanceKInBinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer, Set<Integer>> near = new HashMap<>();
        near.put(root.val, new HashSet<>());
        MakeTopo(near, root, root.left);
        MakeTopo(near, root, root.right);
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[501];
        visited[target.val] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(target.val);
        int n = q.size();
        while (!q.isEmpty() && k > 0){
            int p = q.poll();
            for (Integer x : near.get(p)){
                if (visited[x] == false){
                    visited[x] = true;
                    q.offer(x);
                }
            }
            n--;
            if (n == 0){
                n = q.size();
                k--;
            }
        }
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        return ans;
    }
    void MakeTopo(HashMap<Integer, Set<Integer>> near, TreeNode root, TreeNode t){
        if (t == null ){return;}
        near.put(t.val, new HashSet<>());
        near.get(t.val).add(root.val);
        near.get(root.val).add(t.val);
        MakeTopo(near, t, t.left);
        MakeTopo(near, t, t.right);
    }
}
