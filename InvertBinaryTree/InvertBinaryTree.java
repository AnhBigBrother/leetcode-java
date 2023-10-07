package LeetCode.InvertBinaryTree;

public class InvertBinaryTree {
    public static void main(String[] args) {
        
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){return null;}
        TreeNode ret = new TreeNode(root.val);
        if (root != null){
            ret.left = invertTree(root.right);
            ret.right = invertTree(root.left);
        }
        return ret;
    }
}