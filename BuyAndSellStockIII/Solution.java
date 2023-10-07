package BuyAndSellStockIII;

public class Solution {
    // make 2 arrays maxProfitFrom & maxProfitTo
    // MaxProfitFrom[i] is max profit you get if you buy on day i
    // MaxProfitTo[i] is max profit you get if you sell on day i
    // You only can buy-and-sell two times so your max profit is max(maxProfitFrom[i] + maxProfitTo[i])
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] maxProfitFrom = new int[n];// max profit from i to n-1
        int[] maxProfitTo = new int[n];// max profit from 0 to i
        int max1 = 0;
        int max2 = 0;
        int l = prices[0];
        int r = prices[n-1];
        for (int i=1; i<n; i++){
            if (prices[i] < l){
                l = prices[i];
            }
            max1 = prices[i] - l > max1 ? prices[i] - l : max1;
            maxProfitTo[i] = max1;
        }
        
        for (int i=n-1; i>=0; i--){
            if (prices[i] > r){
                r = prices[i];
            }
            max2 = r - prices[i] > max2 ? r - prices[i] : max2;
            maxProfitFrom[i] = max2;
        }
        
        int ans = 0;
        for (int i=0; i<n; i++){
            if (maxProfitFrom[i] + maxProfitTo[i] > ans){
                ans = maxProfitFrom[i] + maxProfitTo[i];
            }
        }
        return ans;
    }
}