/************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
		    this.data = data;
		    this.left = null;
		    this.right = null;
	    }

    }

************************************************************/

import java.util.*;

public class Solution {
	public static  ArrayList<Integer> traverseBoundary(TreeNode root){
		ArrayList<Integer> ans = new ArrayList();
        if(root==null)
            return ans;
        ans.add(root.data);
        if(root.left==null && root.right==null)
            return ans;
        addLeftSideNodes(root.left,ans);
        addLeafNodes(root,ans);
        ArrayList<Integer> list = new ArrayList();
        addRightSideNodes(root.right,list);
        Collections.reverse(list);
        for(int x:list)
            ans.add(x);
        return ans;
	}
    
    public static void addLeftSideNodes(TreeNode root,ArrayList<Integer> ans)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            return;
        ans.add(root.data);
        if(root.left!=null)
            addLeftSideNodes(root.left,ans);
        else if(root.right!=null)
            addLeftSideNodes(root.right,ans);
    }
    
    public static void addRightSideNodes(TreeNode root,ArrayList<Integer> ans)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            return;
        ans.add(root.data);
        if(root.right!=null)
            addRightSideNodes(root.right,ans);
        else if(root.left!=null)
            addRightSideNodes(root.left,ans);   
    } 
    
    public static void addLeafNodes(TreeNode root,ArrayList<Integer> ans)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            ans.add(root.data);
        addLeafNodes(root.left,ans);
        addLeafNodes(root.right,ans);           
    }       
    
}