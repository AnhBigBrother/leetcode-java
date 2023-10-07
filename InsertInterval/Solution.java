package LeetCode.InsertInterval;

import java.util.Stack;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        Stack <int[]> st = new Stack<int[]>();
        boolean pushed = false;
        for (int i=0; i<n; i++){
            if (intervals[i][1] < newInterval[0]){
                st.push(intervals[i]);
            }
            else if (intervals[i][0] <= newInterval[1]){
                newInterval[0] = newInterval[0] < intervals[i][0] ? newInterval[0] : intervals[i][0];
                newInterval[1] = newInterval[1] > intervals[i][1] ? newInterval[1] : intervals[i][1];
            }
            else {
                if (pushed == false){
                    pushed = true;
                    st.push(newInterval);
                }
                st.push(intervals[i]);
            }
        }
        int m = st.size();
        int [][] ret = new int[m][2];
        int x = m-1;
        while (!st.empty()){
            ret[x][0] = st.peek()[0];
            ret[x][1] = st.peek()[1];
            st.pop();
            x--;
        }
        return ret;
    }
}
