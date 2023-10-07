package LeetCode.MaximumWidthOfBinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null){return 0;}

        HashMap<TreeNode, Integer> widIndex = new HashMap<>();
        makeWidIndex(root, 0, widIndex);

        List<List<Integer>> indexLevelOrder = new ArrayList<>();
        makeListIndexLevelOrder(root, 0, indexLevelOrder, widIndex);
        System.out.println(indexLevelOrder);

        int ans = 1;
        for (List<Integer> l : indexLevelOrder){
            if (l.size() > 1){
                int wid = l.get(l.size()-1) - l.get(0) + 1;
                if (wid > ans) {ans = wid;}
            }
        }
        return ans;
    }
    public void makeWidIndex (TreeNode root, int i, HashMap<TreeNode, Integer> widIndex){
        widIndex.put(root, i);
        if (root.left != null){makeWidIndex(root.left, 2*i, widIndex);}
        if (root.right != null){makeWidIndex(root.right, 2*i+1, widIndex);}
    }
    public void makeListIndexLevelOrder (TreeNode root, int n, List<List<Integer>> indexLevelOrder, HashMap<TreeNode, Integer> widIndex){
        if (root == null){return;}
        if (indexLevelOrder.size() <= n){
            indexLevelOrder.add(new ArrayList<>());
        }
        indexLevelOrder.get(n).add(widIndex.get(root));
        makeListIndexLevelOrder(root.left, n+1, indexLevelOrder, widIndex);
        makeListIndexLevelOrder(root.right, n+1, indexLevelOrder, widIndex);
    }
}
