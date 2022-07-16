/*************************************************************

Following is the Binary Tree Node structure:

    class TreeNode<T> {
		public T data;
		public BinaryTreeNode<T> left;
		public BinaryTreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = null;
			right = null;
	  	}
    }

*************************************************************/

public class Solution {
	public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        int diam[] = new int[1];
        solve(root,diam);
        return diam[0];
	}
    
    public static int solve(TreeNode<Integer> root,int []diam)
    {
        if(root==null)
            return 0;
        int left = solve(root.left,diam);
        int right = solve(root.right,diam);
        diam[0] = Math.max(diam[0],left+right);
        return Math.max(left,right)+1;
    }
    
}