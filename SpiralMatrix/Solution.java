package LeetCode.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int r1 = 0;
        int c1 = 0;
        int r2 = m-1;
        int c2 = n-1;

        List<Integer> ans = new ArrayList<>();
        while (r1 <= r2 && c1 <= c2){
            for (int i=c1; i<=c2; i++){
                if (r1 <= r2){ans.add(matrix[r1][i]);}
            }
            r1++;
            for (int i = r1; i <= r2; i++){
                if (c1 <= c2){ans.add(matrix[i][c2]);}
            }
            c2--;
            for (int i=c2; i>=c1; i--){
                if (r1 <= r2){ans.add(matrix[r2][i]);}
            }
            r2--;
            for (int i=r2; i>=r1; i--){
                if (c1 <= c2){ans.add(matrix[i][c1]);}
            }
            c1++;
        }
        return ans;
    }
    public int[][] generateMatrix(int n) {
        int r1 = 0;
        int r2 = n-1;
        int c1 = 0;
        int c2 = n-1;
        int[][] ans = new int[n][n];
        int run = 1;
        while (c1 <= c2 && r1 <= r2){
            for (int i=c1; i<=c2; i++){
                if (r1 <= r2){ ans[r1][i] = run; run ++;}
            }
            r1++;
            for (int i = r1; i <= r2; i++){
                if (c1 <= c2){ ans[i][c2] = run; run ++;}
            }
            c2--;
            for (int i=c2; i>=c1; i--){
                if (r1 <= r2){ ans[r2][i] = run; run ++;}
            }
            r2--;
            for (int i=r2; i>=r1; i--){
                if (c1 <= c2){ ans[i][c1] = run; run ++;}
            }
            c1++;
        }
        return ans;
    }
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int r1 = 0;
        int r2 = m-1;
        int c1 = 0;
        int c2 = n-1;
        int[][] ans = new int[m][n];
        while (c1 <= c2 && r1 <= r2){
            for (int i=c1; i<=c2; i++){
                if (r1 <= r2){
                    if (head == null){ans[r1][i] = -1;}
                    else {ans[r1][i] = head.val; head = head.next;}
                }
            }
            r1++;
            for (int i = r1; i <= r2; i++){
                if (c1 <= c2){
                    if (head == null){ans[i][c2] = -1;}
                    else {ans[i][c2] = head.val; head = head.next;}
                }
            }
            c2--;
            for (int i=c2; i>=c1; i--){
                if (r1 <= r2){
                    if (head == null){ans[r2][i] = -1;}
                    else {ans[r2][i] = head.val; head = head.next;}
                }
            }
            r2--;
            for (int i=r2; i>=r1; i--){
                if (c1 <= c2){
                    if (head == null){ans[i][c1] = -1;}
                    else {ans[i][c1] = head.val; head = head.next;}
                }
            }
            c1++;
        }
        return ans;
    }

}
class run{
    public static void main(String[] args) {
        int [][] matrix = new Solution().generateMatrix(4);
        for(int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        List<Integer> ans = new Solution().spiralOrder(matrix);
        System.out.println(ans);
    }
}