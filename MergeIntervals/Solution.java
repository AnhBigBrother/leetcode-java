package LeetCode.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    void quicksort(int[][] a, int l, int r){
        int p = a[(l+r)/2][0];
        int i = l;
        int j = r;
        while (i < j){
            while (a[i][0] < p){
                i++;
            }
            while (a[j][0] > p){
                j--;
            }
            if (i<=j){
                int [] temp = new int[2];
                temp[0] = a[i][0];
                temp[1] = a[i][1];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (i < r){quicksort(a, i, r);}
        if (l < j){quicksort(a, l, j);}
    }
    public int[][] merge(int[][] intervals) {
        quicksort(intervals, 0, intervals.length-1);
        List<int[]> l = new ArrayList<int[]>();
        for (int[] i : intervals){
            if (l.size()==0){l.add(i);}
            else{
                if (i[0] <= l.get(l.size()-1)[1]){
                    l.get(l.size()-1)[1] = Integer.max(l.get(l.size()-1)[1], i[1]);
                    l.get(l.size()-1)[0] = Integer.min(l.get(l.size()-1)[0], i[0]);
                }
                else {
                    l.add(i);
                }
            }
        }
        int[][] ans = new int[l.size()][2];
        for (int i=0; i<l.size(); i++){
            ans[i] = l.get(i);
        }
        return ans;
    }
}
