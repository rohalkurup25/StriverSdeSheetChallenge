/*   
    Following is the Binary Tree node structure for referance:

    class TreeNode
    {
        int data;
        TreeNode left, right;
    
        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
*/
import java.util.*;
public class Solution {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        ArrayList<Integer> ans = new ArrayList();
        solve(root,ans,x);
        return ans;
    }
    
    
    public static boolean solve(TreeNode root,ArrayList<Integer> ans,int x)
    {
        if(root==null)
            return false;
        if(root.data==x){
            ans.add(root.data);
            return true;
        }
        ans.add(root.data);
        if(solve(root.left,ans,x))
            return true;
        if(solve(root.right,ans,x))
            return true;
        ans.remove(ans.size()-1);
        return false;
    }
}