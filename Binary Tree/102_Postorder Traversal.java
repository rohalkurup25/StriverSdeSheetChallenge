class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        dfs(ans,root);
        return ans;        
    }
    
    public void dfs(List<Integer> ans , TreeNode root)
    {
        if(root==null)
            return;
        dfs(ans,root.left);
        dfs(ans,root.right);
        ans.add(root.val);
    }    
}