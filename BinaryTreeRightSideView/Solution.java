package BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> NodeLevel = new ArrayList<>();
        sortNodeByHeight(root, NodeLevel, 0);
        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<NodeLevel.size(); i++){
            System.out.println(NodeLevel.get(i));
            ans.add(NodeLevel.get(i).get(NodeLevel.get(i).size()-1));
        }
        return ans;
    }
    void sortNodeByHeight(TreeNode root, List<List<Integer>> NodeLevel, int level){
        if (root == null){return;}
        if (NodeLevel.size() <= level){
            NodeLevel.add(new ArrayList<>());
        }
        NodeLevel.get(level).add(root.val);
        sortNodeByHeight(root.left, NodeLevel, level+1);
        sortNodeByHeight(root.right, NodeLevel, level+1);
    }
}
