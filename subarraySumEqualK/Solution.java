import java.util.HashMap;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(sum, 1);
        for (int i : nums){
            sum += i;
            if (hm.containsKey(sum-k)){
                ans = ans + hm.get(sum-k);
            }
            if (!hm.containsKey(sum)){
                hm.put(sum, 1);
            }
            else{
                hm.put(sum, hm.get(sum)+1);
            }
        }
        return ans;
    }
}
class run {
    public static void main(String[] args) {
        int [] nums={1,-1,0};
        System.out.println(new Solution().subarraySum(nums, 0));
    }
}