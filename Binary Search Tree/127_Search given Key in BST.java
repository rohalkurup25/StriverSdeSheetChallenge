/*
    Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        this.left = null;
	        this.right = null;
	    }
	}
*/

public class Solution {
	public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
		if(root==null)
            return false;
        if(root.data==x)
            return true;
        if(root.data>x)
        {
            if(searchInBST(root.left,x))
                return true;
        }
        else
        {
             if(searchInBST(root.right,x))
                return true;           
        }
        return false;
	}
}