package LeetCode.MinimumCostForTickets;

public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        boolean[] b = new boolean[366];
        for (Integer i : days){
            b[i] = true;
        }
        int[] d = new int [366];
        for (int i=1; i<=days[n-1]; i++){
            if (b[i] == false){d[i] = d[i-1];}
            else{
                int x = i-1<0?0:i-1;
                int y = i-7<0?0:i-7;
                int z = i-30<0?0:i-30;
                d[i] = Integer.min(d[x]+costs[0], d[y] + costs[1]);
                d[i] = Integer.min(d[i], d[z] + costs[2]);
            }
        }
        return d[days[n-1]];
    }
}
