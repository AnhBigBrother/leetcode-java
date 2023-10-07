package LeetCode.DiameterOfBinaryTree;

import java.util.HashMap;

public class Solution {
    HashMap <TreeNode, Integer> level = new HashMap<TreeNode, Integer>();
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        level.put(null, 0);
        findLevel(root);
        findAnswer(root);
        return ans;
    }
    public void findAnswer(TreeNode root){
        if (root == null) {return;}
        int k = level.get(root.left) + level.get(root.right);
        if (ans < k) { ans = k;}
        findAnswer(root.left);
        findAnswer(root.right);
    }
    public int findLevel(TreeNode root){
        if (root == null) {return 0;}
        int l = findLevel(root.left);
        int r = findLevel(root.right);
        int x = l>r ? l:r;
        level.put(root, x+1);
        return x + 1;
    }
}
