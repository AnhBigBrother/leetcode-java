/*
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). 
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. 
A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1){return 0;}
        int[][] nopp = new int[m][n]; // number of possible paths
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                nopp[i][j] = 0;
            }
        }
        nopp[0][0] = 1;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if ((i==0 && j==0) || obstacleGrid[i][j] == 1){continue;}
                if (i != 0 && obstacleGrid[i-1][j] != 1){
                    nopp[i][j] += nopp[i-1][j];
                }
                if (j != 0 && obstacleGrid[i][j-1] != 1){
                    nopp[i][j] += nopp[i][j-1];
                }
            }
        }
        return nopp[m-1][n-1];
    }
}
class run {
    public static void main(String[] args) {
        int [][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(new Solution().uniquePathsWithObstacles(obstacleGrid));
    }
}