package LeetCode.MinimumHeightTrees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
// first idea : DFS + backtracking to find all the heights of all roots
// time comlextity : O(n^2)
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> near = new ArrayList<>();
        for (int i=1;i<=n; i++){
            near.add(new ArrayList<Integer>());
        }
        for (int i=0; i<edges.length; i++){
            near.get(edges[i][0]).add(edges[i][1]);
            near.get(edges[i][1]).add(edges[i][0]);
        }
        int [] height = new int[n];
        boolean [] visited = new boolean[n];
        for (int i=0; i<n; i++){
            if (near.get(i).size() == 1){
                visited[i] = true;
                DFS(i, near, visited, height, 1);
                visited[i] = false;
            }
        }
        int mht = height[0];
        for (int i=1; i<n; i++){
            if (height[i] < mht){
                mht = height[i];
            }
        }
        for (int i=0; i<n; i++){
            if (height[i] == mht){
                ans.add(i);
            }
        }
        return ans;
    }
    void DFS(int p, List<List<Integer>> near, boolean[] visited, int[] height, int h){
        for (int i=0; i<near.get(p).size(); i++){
            int x = near.get(p).get(i);
            if (visited[x] == false){
                visited[x] = true;
                height[x] = Integer.max(height[x], h);
                DFS(x, near, visited, height, h+1);
                visited[x] = false;
            }
        }
    }
}
*/
public class Solution{
    public List<Integer> findMinHeightTrees(int n, int[][] edges){
        List<Integer> ans = new ArrayList<>();
        if (n == 1){
            ans.add(0);
            return ans;
        }
        List<Set<Integer>> near = new ArrayList<>();
        for (int i=1;i<=n; i++){
            near.add(new HashSet<Integer>());
        }
        for (int i=0; i<edges.length; i++){
            near.get(edges[i][0]).add(edges[i][1]);
            near.get(edges[i][1]).add(edges[i][0]);
        }
        Queue <Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[n];
        int [] level = new int[n];
        for (int i=0; i<n; i++){
            if (near.get(i).size() == 1){
                q.add(i);
                visited[i] = true;
                level[i] = 1;
            }
        }
        while (!q.isEmpty()){
            int p = q.peek();
            if (near.get(p).size() == 1){
                int x = near.get(p).iterator().next();
                if (visited[x] == false){
                    level[x] = level[p] + 1;
                    near.get(x).remove(p);
                    if (near.get(x).size() <= 1){
                        q.offer(x);
                        visited[x] = true;
                    }
                }
                else{
                    near.get(x).remove(p);
                    if (near.get(x).isEmpty()){
                        ans.add(x);
                        if (level[p] == level[x]){
                            ans.add(p);
                            return ans;
                        }
                    }
                    else {level[x] = Integer.max(level[x], level[p] + 1);}
                }
            }
            q.poll();
        }
        return ans;
    }
}