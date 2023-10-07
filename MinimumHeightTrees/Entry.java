package LeetCode.MinimumHeightTrees;

import java.util.List;

/*
A tree is an undirected graph in which any two vertices are connected by exactly one path. 
In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, 
and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, 
you can choose any node of the tree as the root. 
When you select a node x as the root, the result tree has height h. 
Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */

public class Entry {
    public static void main(String[] args) {
        // int[][] edge = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7},{9,8},{8,4},{11,10},{10,4},{12,13},{12,4},{14,0},{14,4}};
        // int[][] edge = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        int[][] edge = {{0,1},{1,2},{2,3},{0,4},{4,5},{4,6},{6,7}};
        List<Integer> ans = new Solution().findMinHeightTrees(8, edge);
        System.out.println(ans);
    }
}
