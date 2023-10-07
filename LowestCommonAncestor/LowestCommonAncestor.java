package LeetCode.LowestCommonAncestor;

import java.util.HashMap;;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeNode p = root.left.right;
        TreeNode q = root.left;
        TreeNode ans = new Solution().lowestCommonAncestor(root, p, q);
        System.out.println(ans.val);
    }
}
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> m = new HashMap<TreeNode, TreeNode>();
        HashMap<TreeNode, Integer> level = new HashMap<TreeNode, Integer>();
        setRoot(root, m, level, 1);
        while (level.get(p) > level.get(q)){
            p = m.get(p);
        }
        while (level.get(q) > level.get(p)){
            q = m.get(q);
        }
        while (p != q){
            p = m.get(p);
            q = m.get(q);
        }
        return p;
    }
    public void setRoot(TreeNode x, HashMap<TreeNode, TreeNode> m,HashMap<TreeNode, Integer> level, int l){
        level.put(x, l);
        if (x.left != null){
            m.put(x.left, x);
            setRoot(x.left, m, level, l+1);
        }
        if (x.right != null){
            m.put(x.right, x);
            setRoot(x.right, m, level, l+1);
        }
    }
}