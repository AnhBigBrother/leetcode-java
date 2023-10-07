package LeetCode.TreeLevelOrderTraversal;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        solve(ans, root, 0);
        return ans;
    }
    public void solve (List<List<Integer>> ans, TreeNode root, int level){
        if (root == null){return;}
        if (ans.size() <= level){
            ans.add(new ArrayList<Integer>());
        }
        ans.get(level).add(root.val);
        solve(ans, root.left, level+1);
        solve(ans, root.right, level+1);
    }
}
