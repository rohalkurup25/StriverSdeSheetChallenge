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

import java.util.*;

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        ArrayList<Integer> ans = new ArrayList();
        HashSet<Integer> set = new HashSet();
        solve(root,ans,0,set);
        return ans;
    }
    
    public static void solve(TreeNode<Integer> root, ArrayList<Integer> ans,int level, HashSet<Integer> set)
    {
        if(root==null)
            return ;
        if(!set.contains(level)){
            ans.add(root.data);
            set.add(level);
        }
        solve(root.left,ans,level+1,set);
        solve(root.right,ans,level+1,set);
    }
}