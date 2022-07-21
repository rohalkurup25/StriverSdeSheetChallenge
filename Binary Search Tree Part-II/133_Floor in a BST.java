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

public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        int ans[] = new int[1];
        solve(root,X,ans);
        return ans[0];
    }
    
    public static void solve(TreeNode<Integer> root,int X,int []ans)
    {
        if(root==null)
            return;
        if(root.data<=X)
        {
            ans[0] = root.data;
            solve(root.right,X,ans);
        }
        else
        solve(root.left,X,ans);
    }
}