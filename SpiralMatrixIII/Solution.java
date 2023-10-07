package LeetCode.SpiralMatrixIII;

public class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int [][] ans = new int[rows*cols][2];
        ans[0][0] = rStart;
        ans[0][1] = cStart;
        int r1 = rStart;
        int r2 = rStart;
        int c1 = cStart;
        int c2 = cStart;

        int p=1;
        while (p < rows*cols){
            if (c2 < cols){c2++;}
            if (r1 >= 0){
                for (int i=c1+1; i<=c2; i++){
                    if (i >= cols || p >= rows*cols){break;}
                    ans[p][0] = r1;
                    ans[p][1] = i;
                    p++;
                }
            }
            if (r2 < rows){r2++;}
            if (c2 < cols){
                for (int i=r1+1; i<=r2; i++){
                    if (i >= rows || p >= rows*cols){break;}
                    ans[p][0] = i;
                    ans[p][1] = c2;
                    p++;
                }
            }
            if (c1 >= 0){c1--;}
            if (r2 < rows){
                for (int i=c2-1; i>=c1; i--){
                    if (i < 0 || p >= rows*cols){break;}
                    ans[p][0] = r2;
                    ans[p][1] = i;
                    p++;
                }
            }
            if (r1 >= 0){r1--;}
            if (c1 >= 0){
                for (int i=r2-1; i>=r1; i--){
                    if (i < 0 || p >= rows*cols) {break;}
                    ans[p][0] = i;
                    ans[p][1] = c1;
                    p++;
                }
            }
        }

        return ans;
    }
}
class run {
    public static void main(String[] args) {
        int rows = 5, cols = 6, rStart = 1, cStart = 4;
        int [][] ans = new Solution().spiralMatrixIII(rows, cols, rStart, cStart);
        for (int i=0; i<ans.length; i++){
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }
}