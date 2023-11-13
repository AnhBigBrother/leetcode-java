import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution{
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> permu = new HashSet<>();
        Boolean[] visited = new Boolean[nums.length];
        for(int i=0; i<nums.length; i++){
            visited[i] = false;
        }
        backtrack(nums, visited, permu, new ArrayList<>());

        return new ArrayList<>(permu);
    }
    void backtrack(int [] nums, Boolean[] visited, Set<List<Integer>> permu, List<Integer> ele) {
        if (ele.size() == nums.length){
            permu.add(ele);
            return ;
        }
        for (int i=0; i<nums.length; i++){
            if (visited[i] == false){
                visited[i] = true;
                ele.add(nums[i]);
                backtrack(nums, visited, permu, new ArrayList<>(ele));
                ele.remove(ele.size()-1);
                visited[i] = false;
            }
        }        
    }
}
class run {
    public static void main(String[] args) {
        int [] nums = {1,1,2,3};
        List<List<Integer>> ans = new Solution().permuteUnique(nums);
        for (int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
}