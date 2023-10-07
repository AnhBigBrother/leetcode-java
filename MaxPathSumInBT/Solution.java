package LeetCode.MaxPathSumInBT;

import java.util.HashMap;

public class Solution {
    int ans;
    public int maxPathSum(TreeNode root) {
        HashMap<TreeNode, Integer> Max = new HashMap<>();
        findMaxForNode(root, Max);
        ans = Max.get(root);
        solve(root, Max);

        return ans;
    }
    void findMaxForNode(TreeNode root, HashMap<TreeNode, Integer> Max){
        if (root.left == null && root.right == null){
            Max.put(root, root.val);
        }
        else if (root.left != null && root.right == null){
            findMaxForNode(root.left, Max);
            int x = root.val + Max.get(root.left) > root.val ? root.val + Max.get(root.left) : root.val;
            x = Integer.max(x, root.val);
            Max.put(root, x);
        }
        else if (root.left == null && root.right != null){
            findMaxForNode(root.right, Max);
            int x = root.val + Max.get(root.right) > root.val ? root.val + Max.get(root.right) : root.val;
            x = Integer.max(x, root.val);
            Max.put(root, x);
        }
        else {
            findMaxForNode(root.left, Max);
            findMaxForNode(root.right, Max);
            int x = root.val + Integer.max(Max.get(root.left), Max.get(root.right));
            x = Integer.max(x, root.val);
            Max.put(root, x);
        }
    }
    void solve(TreeNode root, HashMap<TreeNode, Integer> Max){
        if (root == null){ return ;}
        if (root.left != null){
            ans = ans > root.val+Max.get(root.left) ? ans : root.val+Max.get(root.left);
            ans = ans > Max.get(root.left) ? ans : Max.get(root.left);
        }
        if (root.right != null){
            ans = ans > root.val+Max.get(root.right) ? ans : root.val+Max.get(root.right);
            ans = ans > Max.get(root.right) ? ans : Max.get(root.right);
        }
        if (root.left != null && root.right != null){
            ans = ans > root.val + Max.get(root.left) + Max.get(root.right) ? ans : root.val + Max.get(root.left) + Max.get(root.right);
        }
        ans = Integer.max(root.val, ans);
        solve(root.left, Max);
        solve(root.right, Max);
    }
}
class run{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-2);
        System.out.println(new Solution().maxPathSum(root));
    }
}