package LeetCode.ValidateBinarySearchTree;

public class Entry {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(4);
        TreeNode rl = new TreeNode(3);
        TreeNode rr = new TreeNode(7);
        TreeNode right = new TreeNode(6, rl, rr);
        TreeNode root = new TreeNode(5, left, right);
        System.out.println(new Solution().isValidBST(root)); // false
    }
}
