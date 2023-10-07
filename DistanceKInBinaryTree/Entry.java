package LeetCode.DistanceKInBinaryTree;

public class Entry {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode target = new TreeNode(5);
        target.left = new TreeNode(6);
        target.right = new TreeNode(2);
        target.right.left = new TreeNode(7);
        target.right.right = new TreeNode(4);
        root.left = target;
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.left = new TreeNode(0);
        System.out.println(new Solution().distanceK(root, target, 2));
    }
}
