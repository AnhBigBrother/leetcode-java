import java.util.ArrayList;
import java.util.List;

public class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        List<Long> preSum = new ArrayList<>();
        long x = 0;
        preSum.add(x);
        solve(root, 0, preSum, targetSum);
        return count;
    }
    void solve(TreeNode root, long currSum, List<Long> preSum, int target){
        if (root == null){
            return;
        }
        currSum += root.val;
        for (int i=0;  i<preSum.size(); i++){
            if (target == currSum - preSum.get(i)){
                count ++;
            }
        }
        preSum.add(currSum);
        solve(root.left, currSum, new ArrayList<>(preSum), target);
        solve(root.right, currSum, new ArrayList<>(preSum), target);
    }
}

class run {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        System.out.println(new Solution().pathSum(root, 8));
    }
}