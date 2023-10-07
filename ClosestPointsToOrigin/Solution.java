package LeetCode.ClosestPointsToOrigin;


public class Solution {
    public void sort(int[][] points, int d[], int l, int r){
        int m = d[(l+r)/2];
        int i = l;
        int j = r;
        while (i < j){
            while (d[i] < m){
                i++;
            }
            while (d[j] > m){
                j--;
            }
            if (i <= j){
                int temp = d[i];
                d[i] = d[j];
                d[j] = temp;
                int [] t = points[i];
                points[i] = points[j];
                points[j] = t;
                i++;
                j--;
            }
        }
        if (i < r){sort(points, d, i, r);}
        if (l < j){sort(points, d, l, j);}
    }
    public int[][] kClosest(int[][] points, int k) {
        int [] d = new int [points.length];
        int [][] ret = new int [k][2];
        for (int i=0; i<points.length; i++){
            d[i] = points[i][0]*points[i][0] + points[i][1]*points[i][1];
        }
        sort(points, d, 0, d.length-1);
        for (int i=0; i<k; i++){
            ret[i] = points[i];
        }
        return ret;
    }
}
