package LeetCode.PacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        Queue<Integer> Pacific = new LinkedList<>();
        Queue<Integer> Atlantic = new LinkedList<>();
        boolean[][] flowToPacific = new boolean[m][n];
        boolean[][] flowToAtlantic = new boolean[m][n];
        for (int i=0; i<n; i++){
            Pacific.offer(i);
            Atlantic.offer((m-1)*n+i);
            flowToPacific[0][i] = true;
            flowToAtlantic[m-1][i] = true;
        }
        for (int i=0; i<m; i++){
            Pacific.offer(i*n);
            Atlantic.offer(i*n+n-1);
            flowToPacific[i][0] = true;
            flowToAtlantic[i][n-1] = true;
        }
        while (!Pacific.isEmpty()){
            int p = Pacific.poll();
            int x = p/n;
            int y = p%n;
            if (x-1 >= 0 && flowToPacific[x-1][y] == false && heights[x-1][y] >= heights[x][y]){
                flowToPacific[x-1][y] = true;
                Pacific.offer((x-1)*n + y);
            }
            if (y-1 >= 0 && flowToPacific[x][y-1] == false && heights[x][y-1] >= heights[x][y]){
                flowToPacific[x][y-1] = true;
                Pacific.offer(x*n + y -1);
            }
            if (x+1 < m && flowToPacific[x+1][y] == false && heights[x+1][y] >= heights[x][y]){
                flowToPacific[x+1][y] = true;
                Pacific.offer((x+1)*n + y);
            }
            if (y+1 < n && flowToPacific[x][y+1] == false && heights[x][y+1] >= heights[x][y]){
                flowToPacific[x][y+1] = true;
                Pacific.offer(x*n + y + 1);
            }
        }
        while (!Atlantic.isEmpty()){
            int p = Atlantic.poll();
            int x = p/n;
            int y = p%n;
            if (x-1 >= 0 && flowToAtlantic[x-1][y] == false && heights[x-1][y] >= heights[x][y]){
                flowToAtlantic[x-1][y] = true;
                Atlantic.offer((x-1)*n + y);
            }
            if (y-1 >= 0 && flowToAtlantic[x][y-1] == false && heights[x][y-1] >= heights[x][y]){
                flowToAtlantic[x][y-1] = true;
                Atlantic.offer(x*n + y -1);
            }
            if (x+1 < m && flowToAtlantic[x+1][y] == false && heights[x+1][y] >= heights[x][y]){
                flowToAtlantic[x+1][y] = true;
                Atlantic.offer((x+1)*n + y);
            }
            if (y+1 < n && flowToAtlantic[x][y+1] == false && heights[x][y+1] >= heights[x][y]){
                flowToAtlantic[x][y+1] = true;
                Atlantic.offer(x*n + y + 1);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (flowToAtlantic[i][j] && flowToPacific[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i); temp.add(j);
                    ans.add(new ArrayList<>(temp));
                }
            }
        }
        return ans;
    }
}
