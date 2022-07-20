/*

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

*/

public class Solution 
{

	public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) 
    {		
        if(root==null)
            return null;
        if((root.data>=p.data && root.data <=q.data) || (root.data<=p.data && root.data>=q.data))
            return root;
        if(root.data>p.data)
            return LCAinaBST(root.left,p,q);
        else
            return LCAinaBST(root.right,p,q);
	}
}