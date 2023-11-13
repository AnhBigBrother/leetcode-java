/*
Construct Binary Tree from level-order and Inorder Traversal
Given two integer arrays levelorder and inorder where levelorder is the level-order traversal of a binary tree 
and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode buildTree(int[] levelorder, int[] inorder) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        for (int i=0; i<levelorder.length; i++){
            pre.add(levelorder[i]);
            in.add(inorder[i]);
        }
        return solve(pre, in);
    }
    TreeNode solve(List<Integer> levelorder, List<Integer> inorder) {
        if (levelorder.size() == 0){
            return null;
        }
        int n = levelorder.size();
        TreeNode root = new TreeNode(levelorder.get(0));
        List<Integer> leftInorder = new ArrayList<>();
        List<Integer> rightInorder = new ArrayList<>();
        int p=0;
        for (int i=0; i<n; i++){
            if (inorder.get(i) == levelorder.get(0)){
                p = i;
            }
        }
        for (int i=0; i<p; i++){
            leftInorder.add(inorder.get(i));
        }
        for(int i=p+1; i<n; i++){
            rightInorder.add(inorder.get(i));
        }
        List<Integer> leftlevelorder = new ArrayList<>();
        List<Integer> rightlevelorder = new ArrayList<>();
        for(int x=1; x<n; x++){
            if (leftInorder.contains(levelorder.get(x))){
                leftlevelorder.add(levelorder.get(x));
            }
            else {
                rightlevelorder.add(levelorder.get(x));
            }
        }
        root.left = solve(leftlevelorder, leftInorder);
        root.right = solve(rightlevelorder, rightInorder);
        return root;
    }
}

class run {
    public static void main(String[] args) {
        int [] levelorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        TreeNode root = new Solution().buildTree(levelorder, inorder);
    }
}