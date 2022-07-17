/************************************************************

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

************************************************************/

public class Solution 
{
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) 
    {
        if(root==null)
            return -1;
        if(root.data==x || root.data==y)
            return root.data;
        int leftNode = lowestCommonAncestor(root.left,x,y);
        int rightNode = lowestCommonAncestor(root.right,x,y);
        if(leftNode==-1)
            return rightNode;
        if(rightNode==-1)
            return leftNode;
        return root.data;
    }
}