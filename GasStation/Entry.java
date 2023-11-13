package GasStation;

public class Entry {
    public static void main(String[] args) {
        int [] gas = {5,1,3,2,10};
        int [] cost = {1,6,3,3,1};
        System.out.println(new Solution().canCompleteCircuit(gas, cost));
    }
}
