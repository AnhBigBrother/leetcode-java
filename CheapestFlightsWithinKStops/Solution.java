package CheapestFlightsWithinKStops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Integer>> nextCities = new ArrayList<>();
        for (int i=0; i<n; i++){
            nextCities.add(new ArrayList<>());
        }
        int [][] airFares = new int[n][n];
        for (int i=0; i<flights.length; i++){
            nextCities.get(flights[i][0]).add(flights[i][1]);
            airFares[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        
        int [][] ans = new int[k+2][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<=k+1; j++){
                ans[j][i] = -1;
            }
        }
        ans[0][src] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        int s=q.size();
        int k2 = 1;
        while(!q.isEmpty()){
            int x = q.poll();
            s--;
            for (int i : nextCities.get(x)){
                if (ans[k2][i] == -1 || ans[k2-1][x] + airFares[x][i] < ans[k2][i]){
                    ans[k2][i] = ans[k2-1][x] + airFares[x][i];
                    q.offer(i);
                }
            }
            if (s == 0){
                k2++;
                s = q.size();
            }
            if (k2 > k+1){
                break;
            }
        }
        int a = -1;
        for (int i=0; i<k2; i++){
            if (a == -1 || (ans[i][dst] != -1 && ans[i][dst] < a)){
                a = ans[i][dst];
            }
        }
        return a;
    }
}
class run {
    public static void main(String[] args) {
        int[][] flights = {{0,1,2},{1,2,1},{2,0,10}};
        System.out.println(new Solution().findCheapestPrice(3, flights, 1, 2, 1));
    }
}