package LeetCode.DailyTemperatures;

public class Entry {
    public static void main(String[] args) {
        int [] temperatures = {34,80,80,34,34,80,80,80,80,34};
        int [] ans = new Solution().dailyTemperatures(temperatures);
        for (int x : ans){
            System.out.print(x + " ");
        }
    }
}
