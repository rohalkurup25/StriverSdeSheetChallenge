/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode < Integer > {
        int data;
        BinaryTreeNode < Integer > left;
        BinaryTreeNode < Integer > right;

    public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/

public class Solution {
    public static void changeTree(BinaryTreeNode < Integer > root) {
		 solve(root);
        }
    public static int solve(BinaryTreeNode root)
    {
        if(root==null)
        return 0;
        if(root.left==null && root.right==null)
            return root.data;
        int sum = 0;
        if(root.left!=null)
            sum+=root.left.data;
        if(root.right!=null)
            sum+=root.right.data;
        if(root.data>sum)
        {
            if(root.left!=null)
                root.left.data = root.data;
            if(root.right!=null)
                root.right.data = root.data;
        }
        int leftVal = solve(root.left);
        int rightVal = solve(root.right);
        
        root.data = leftVal+rightVal;
        return root.data;
    }
    
    
}
