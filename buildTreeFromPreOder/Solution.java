/*
Construct Binary Tree from preorder and Inorder Traversal
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree 
and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example:

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
 */

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, inorder, 0, 0, inorder.length-1);
    }
    TreeNode solve(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
        int n = inorder.length;
        if (preStart >= n || inStart > inEnd){return null;}
        TreeNode root = new TreeNode(preorder[preStart]);
        int p=0;
        for (int i=0; i<n; i++){
            if (preorder[preStart] == inorder[i]){
                p = i;
                break;
            }
        }
        root.left = solve(preorder, inorder, preStart+1, inStart, p-1);
        root.right = solve(preorder, inorder, preStart + p - inStart + 1, p+1, inEnd);
        return root;
    }
}

class run{
    public static void main(String[] args) {
        int [] inorder = {9,3,15,20,7};
        int [] postorder = {9,15,7,20,3};
        System.out.println(new Solution().buildTree(inorder, postorder));
    }
}