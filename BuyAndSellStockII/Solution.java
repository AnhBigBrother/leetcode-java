package BuyAndSellStockII;

public class Solution {
    // buy when the price starts to rise
    // sell when the price starts to fall
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = 0;
        int profit = 0;
        int i=1;
        while (i < prices.length){
            while(prices[i-1] > prices[i]){
                buy = prices[i];
                i++;
                if (i >= prices.length){return profit;}
            }
            while(prices[i-1] <= prices[i]){
                sell = prices[i];
                i++;
                if (i >= prices.length){break;}
            }
            profit += sell - buy;
        }
        return profit;
    }
}
