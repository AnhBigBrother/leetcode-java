package LeetCode.Search2DMatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i=0; int j = m-1;
        while (i <= j){
            int x = (i+j)/2;
            if (target > matrix[x][n-1]){i = x+1;}
            else if (target < matrix[x][n-1]){j = x;}
            else {return true;}
            if (i == j){break;}
            if (i >= m || j < 0){return false;}
        }
        System.out.println(i + " " + j);
        int l=0; int r = n-1;
        while (l <= r){
            int x = (l+r)/2;
            if (target > matrix[i][x]){l = x+1;}
            else if (target < matrix[i][x]){r = x-1;}
            else {return true;}
        }
        return false;
    }
}
