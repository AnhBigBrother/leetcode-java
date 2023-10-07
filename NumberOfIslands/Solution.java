package LeetCode.NumberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int numIslands(char[][] grid) {
        Queue <Integer> q = new LinkedList<>();
        int n = grid.length;// so hang
        int m = grid[0].length;// so cot
        int ans = 0;
        for (int i=0; i<m*n; i++){
            int x = i/m;
            int y = i%m;
            if (grid[x][y] == '1'){
                q.add(i);
                ans++;
                while (!q.isEmpty()){
                    int p = q.peek();
                    q.remove();
                    int u = p/m;
                    int v = p%m;
                    grid[u][v] = '0';
                    if (u-1>=0 && grid[u-1][v] == '1'){
                        q.add((u-1)*m + v);
                        grid[u-1][v] = '0';
                    }
                    if (v-1>=0 && grid[u][v-1] == '1'){
                        q.add(u*m+(v-1));
                        grid[u][v-1] = '0';
                    }
                    if (u+1<n && grid[u+1][v] == '1'){
                        q.add((u+1)*m+v);
                        grid[u+1][v] = '0';
                    }
                    if (v+1<m && grid[u][v+1] == '1'){
                        q.add(u*m+(v+1));
                        grid[u][v+1] = '0';
                    }
                }
            }
        }
        return ans;
    }
}
