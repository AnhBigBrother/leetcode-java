package LeetCode.UniquePaths;

public class Solution {
    public int uniquePaths(int m, int n) {
        int [][] count = new int[m+2][n+2];
        count[1][1] = 1;
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (!(i == 1 && j == 1)){
                    count[i][j] = count[i-1][j]+count[i][j-1];
                }
            }
        }
        return count[m][n];
    }
}
