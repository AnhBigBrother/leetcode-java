package LeetCode.PathSumII;


public class Entry {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l = new TreeNode(4);
        TreeNode r = new TreeNode(8);
        l.left = new TreeNode(11);
        l.left.left = new TreeNode(7);
        l.left.right = new TreeNode(2);
        r.left = new TreeNode(13);
        r.right = new TreeNode(4);
        r.right.right = new TreeNode(1);
        r.right.left = new TreeNode(5);
        root.left = l;
        root.right = r;
        System.out.println(new Solution().pathSum(root, 22));
    }
}
