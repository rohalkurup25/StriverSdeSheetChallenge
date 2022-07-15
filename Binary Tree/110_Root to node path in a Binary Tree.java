/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ans = new ArrayList();
        solve(A,B,ans);
        return ans;
    }

    public boolean solve(TreeNode root,int target,ArrayList<Integer> ans)
    {
        if(root==null)
        return false;
        if(root.val==target)
        {
            ans.add(root.val);
            return true;
        }

        ans.add(root.val);
        if(solve(root.left,target,ans))
        return true;
        if(solve(root.right,target,ans))
        return true;
        ans.remove(ans.size()-1);
        return false;
    }
}