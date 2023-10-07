package LeetCode.KthSmallestElementInBST;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList node = new LinkedList(root.val);
        makeLinkedList(root, node);
        while (node.left != null){
            node = node.left;
        }
        int ans = -1;
        while (k > 0){
            ans = node.val;
            node = node.right;
            k--;
        }
        return ans;
    }
    void makeLinkedList(TreeNode root, LinkedList node){
        if (root == null){return;}
        if (root.left != null){
            if (node.left == null){
                LinkedList x = new LinkedList(root.left.val);
                node.left = x;
                x.right = node;
            }
            else {
                LinkedList nleft = node.left;
                LinkedList insert = new LinkedList(root.left.val);
                nleft.right = insert;
                insert.left = nleft;
                node.left = insert;
                insert.right = node;
            }
        }
        if (root.right != null){
            if (node.right == null){
                LinkedList x = new LinkedList(root.right.val);
                node.right = x;
                x.left = node;
            }
            else {
                LinkedList nright = node.right;
                LinkedList insert = new LinkedList(root.right.val);
                nright.left = insert;
                insert.right = nright;
                node.right = insert;
                insert.left = node;
            }
        }
        makeLinkedList(root.left, node.left);
        makeLinkedList(root.right, node.right);
    }
}
