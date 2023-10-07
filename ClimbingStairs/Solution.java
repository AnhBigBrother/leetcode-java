package ClimbingStairs;


/*
 * to go to (i)th step, there are two ways:
 * - from step (i-1)th climb 1 step;
 * - or from step (i-2)th climb 2 steps; 
 * there are d[i-1] ways to climb to (i-1)th step;
 * and there are d[i-2] ways to climb to (i-2)th step;
 * so d[i] = d[i-1] + d[i-2]; 
 */
public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {return 1;}
        int [] d = new int [n+1];
        d[1] = 1;
        d[2] = 2;
        for (int i=3;i<n+1; i++){
            d[i] = d[i-1] + d[i-2];
        }
        return d[n];
    }
}
