package LeetCode.CoinChange;

public class Entry {
    public static void main(String[] args) {
        int [] coins = {1,2,5};
        int amount = 11;
        System.out.println(new Solution().CoinChange(coins, amount));
    }
}
