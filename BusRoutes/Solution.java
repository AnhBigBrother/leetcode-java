package BusRoutes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer,List<Integer>> busGoThrough = new HashMap<>();
        for (int i=0; i<routes.length; i++){
            for (int j=0; j<routes[i].length; j++){
                if (!busGoThrough.containsKey(routes[i][j])){
                    busGoThrough.put(routes[i][j], new ArrayList<>());
                }
                busGoThrough.get(routes[i][j]).add(i);
            }
        }
        for (int x : busGoThrough.keySet()){
            System.out.println(x + " : " + busGoThrough.get(x));
        }
        
        boolean[] visitedBus = new boolean[501];
        for (int i=0; i<=500; i++){visitedBus[i] = false;}
        boolean[] visitedPos = new boolean[100001];
        for (int i=0; i<=100000; i++){visitedPos[i] = false;}
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        int ans = 0;
        int n = q.size();
        visitedPos[source] = true;
        while (!q.isEmpty()){
            int x = q.poll();
            if (x == target){return ans;}
            n--;
            for (int b : busGoThrough.get(x)){
                if (visitedBus[b] == false){
                    visitedBus[b] = true;
                    for (int p : routes[b]){
                        if (visitedPos[p] == false){
                            visitedPos[p] = true;
                            q.offer(p);
                        }
                    }
                }
            }
            if (n == 0){
                ans++;
                n = q.size();
            }
        }
        return -1;
    }
}
class run {
    public static void main(String[] args) {
        int[][] routes = {{7,12},{4,5,15},{6},{15,19,13},{9,12,13}};
        System.out.println(new Solution().numBusesToDestination(routes, 7, 5));
    }
}