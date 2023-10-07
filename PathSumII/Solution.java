package LeetCode.PathSumII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        BFS(root, new ArrayList<>(), root.val, targetSum);
        return ans;
    }
    void BFS(TreeNode root, List<Integer> l, int sum, int target){
        if (root == null ) {return;}
        List<Integer> a = new ArrayList<>(l);
        a.add(root.val);
        if (root.left == null && root.right == null){
            if (sum == target) {ans.add(a);}
            return;
        }
        if (root.left != null){BFS(root.left, a, sum+root.left.val, target);}
        if (root.right != null){BFS(root.right, a, sum+root.right.val, target);}
    }
}
