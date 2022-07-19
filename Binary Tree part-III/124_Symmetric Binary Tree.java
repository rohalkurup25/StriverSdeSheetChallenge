/*****************************************************************

    Following is the representation for the Binary Tree Node:

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

****************************************************************/

public class Solution {

    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        return solve(root,root);
    }
    
    public static boolean solve(BinaryTreeNode<Integer> root1,BinaryTreeNode<Integer> root2)
    {
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        if((root1.data%1000000007)!=(root2.data%1000000007))
            return false;
        return solve(root1.left,root2.right) && solve(root1.right,root2.left);
    }
    
}