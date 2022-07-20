/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

 *************************************************************/

public class Solution {
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        return solve(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public static boolean solve(BinaryTreeNode<Integer> root,int start,int end)
    {
        if(root==null)
            return true;
        if(root.data<start || root.data>end)
            return false;
        boolean leftNode = solve(root.left,start,root.data);
        boolean rightNode = solve(root.right,root.data,end);
        return leftNode && rightNode;
    }
    
} 