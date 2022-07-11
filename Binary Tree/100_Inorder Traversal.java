class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        solve(root,ans);
        return ans;
    }
    
    public void solve(TreeNode root,List<Integer> ans)
    {
        if(root==null)
            return;
        solve(root.left,ans);
        ans.add(root.val);
        solve(root.right,ans);
    }
}