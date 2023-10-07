package LeetCode.ValidateBinarySearchTree;


public class Solution {
    public boolean isValidBST(TreeNode root) {
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean solve(TreeNode root, Long l, Long r){
        if (root == null){return true;}
        if (root.val <= l || root.val>=r){return false;}
        return solve(root.left, l, Long.valueOf(root.val)) && solve(root.right, Long.valueOf(root.val), r);
    }
}
