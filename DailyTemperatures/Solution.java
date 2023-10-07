package LeetCode.DailyTemperatures;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] ans = new int[temperatures.length];
        for (int i=0; i<ans.length; i++){
            if (i > 0 && temperatures[i] == temperatures[i-1]){
                if (ans[i-1] != 0){
                    ans[i] = ans[i-1] - 1;
                }
            }
            else{
                for (int j=i+1; j<ans.length; j++){
                    if (temperatures[j] > temperatures[i]){
                        ans[i] = j-i;       
                        break;                
                    }
                }
            }
        }
        return ans;
    }
}
