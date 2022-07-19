/************************************************************

    Following is the TreeNode class structure.

	class TreeNode<T> 
	{
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) 
	    {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

************************************************************/

public class Solution 
{
    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root)
    {
        TreeNode<Integer> []node = new TreeNode[1];
        node[0] = null;
         solve(root,node);
        return root;
    }
    
    public static void solve(TreeNode<Integer> root, TreeNode<Integer> [] prev)
    {
        if(root==null)
            return ;
        solve(root.right,prev);
        solve(root.left,prev);
        if(prev[0]==null)
            prev[0]=root;
        else
        {
            root.right = prev[0];
            prev[0] = root;
        }
    }
    
}