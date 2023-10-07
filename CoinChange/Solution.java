package LeetCode.CoinChange;

// With Dynamic Programming, complexity is O(coins.length*amount)
// With Back Tracking , complexity is about O((amount^coins.length)/x)
//                       (x = product of all elements in coints array) 
// In this problem, 1<= coins.length <= 12 and 0 <= amouunt <= 10000
// So we should do with Dynamic Programming
public class Solution {
    public int CoinChange(int [] coins, int amount){
        if (amount == 0){return 0;}
        int[] d = new int[amount+1];
        for(int i=0; i<=amount; i++){
            d[i] = -1;
        }
        for (Integer x : coins){
            if (x <= amount){d[x] = 1;}
        }
        for (int i=1; i<=amount; i++){
            for (Integer x : coins){
                if (x < i && d[i-x] != -1){
                    if (d[i] == -1){d[i] = d[i-x] + 1;}
                    else {d[i] = d[i-x] + 1 < d[i] ? d[i-x] + 1 : d[i] ;}
                }
            }
        }
        return d[amount];
    }
}
