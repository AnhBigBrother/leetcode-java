package LeetCode.RottingOranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Integer> q = new LinkedList<Integer>();
        int n = grid.length;// number of row
        int m = grid[0].length;// number of column
        int freshOrange = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (grid[i][j] == 2){
                    q.offer(i*m+j);
                }
                if (grid[i][j] == 1){
                    freshOrange++;
                }
            }
        }
        int k = q.size();
        int ans = 0;
        while (!q.isEmpty()){
            int p = q.poll();
            k--;
            int x = p/m;
            int y = p%m;
            if (x-1 >= 0 && grid[x-1][y] == 1){
                q.offer((x-1)*m + y);
                grid[x-1][y] = 2;
                freshOrange--;
            }
            if (x+1 < n && grid[x+1][y] == 1){
                q.offer((x+1)*m + y);
                grid[x+1][y] = 2;
                freshOrange--;
            }
            if (y-1 >= 0 && grid[x][y-1] == 1){
                q.offer(x*m + y-1);
                grid[x][y-1] = 2;
                freshOrange--;
            }
            if (y+1 < m && grid[x][y+1] == 1){
                q.offer(x*m + y+1);
                grid[x][y+1] = 2;
                freshOrange--;
            }
            if (k == 0){
                ans ++;
                k = q.size();
            }
        }
        if (freshOrange > 0) {return -1;}
        return ans;
    }
}
