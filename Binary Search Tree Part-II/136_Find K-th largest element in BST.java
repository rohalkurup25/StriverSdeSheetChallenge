/*************************************************************
    Following is the Binary Search Tree node structure

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************/

import java.util.ArrayList;

public class Solution {
	public static int KthLargestNumber(TreeNode<Integer> root, int k) {
        int ans[] = new int[1];
        ans[0]=-1;
        int count[] = new int[1];
        solve(root,k,ans,count);
        return ans[0];	
    }
    
    public static void solve(TreeNode<Integer> root,int k, int ans[], int count[])
    {
        if(root==null)
            return;
        solve(root.right,k,ans,count);
        if(count[0]==k-1)
            ans[0]=root.data;
        count[0]++;
        solve(root.left,k,ans,count);
    }

}