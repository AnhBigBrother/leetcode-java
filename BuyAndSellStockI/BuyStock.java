package BuyAndSellStockI;

public class BuyStock {
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(prices));
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int mi = prices[0];
        int ret = 0;
        for (int i=1; i<prices.length; i++){
            if (prices[i] < mi){mi = prices[i];}
            else {
                if (prices[i] - mi > ret){
                    ret = prices[i] - mi;
                }
            }
        }
        return ret;
    }
}
