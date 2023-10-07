package BinaryTreeRightSideView;

import java.util.List;

public class Entry {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.left.left.left.right = new TreeNode(9);
        List<Integer> ans = new Solution().rightSideView(root);
        System.out.println(ans);
    }
}
