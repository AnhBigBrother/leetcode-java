
/*
Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right, 
which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        for (int i=1; i<m; i++){
            grid[0][i] = grid[0][i-1] + grid[0][i];
        }
        for (int j=1; j<n; j++){
            grid[j][0] = grid[j-1][0] + grid[j][0];
        }
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                int x = grid[j][i-1] < grid[j-1][i] ? grid[j][i-1] : grid[j-1][i];
                grid[j][i] = x + grid[j][i];
            }
        }
        return grid[n-1][m-1];
    }
}
class run {
    public static void main(String[] args) {
        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new Solution().minPathSum(grid));
        int [][] grid2 = {{1,2,3}, {4,5,6}};
        System.out.println(new Solution().minPathSum(grid2));
    }
}
