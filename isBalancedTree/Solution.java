package LeetCode.isBalancedTree;

import java.util.HashMap;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        HashMap<TreeNode, Integer> level = new HashMap<TreeNode, Integer>();
        level.put(null, 0);
        getLevel(root, level);
        return ans(root, level);
    }
    public boolean ans(TreeNode root, HashMap<TreeNode, Integer> level){
        if (root == null){return true;}
        if (level.get(root.left) > level.get(root.right) + 1 || level.get(root.left) < level.get(root.right) - 1){
            return false;
        }
        return ans(root.left, level)&&ans(root.right, level);
    }
    public int getLevel(TreeNode root, HashMap<TreeNode, Integer> level){
        if (root == null){return 0;}
        int x = getLevel(root.left, level);
        if (x < getLevel(root.right, level)){x = getLevel(root.right, level);}
        level.put(root, x+1);
        System.out.println("root: " + root.val + " - level: " + level.get(root));
        return x+1;
    }
}