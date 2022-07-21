/*************************************************************************

    Following is the class structure of the Node class:

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

*************************************************************************/

public class Solution {
    
    static class Node
    {
        int min;
        int max;
        int count;
        boolean isBST;
        
        Node(int min,int max,int count,boolean isBST)
        {
            this.min = min;
            this.max = max;
            this.count = count;
            this.isBST = isBST;
        }
    }
    
	public static int largestBST(TreeNode<Integer> root) {
        if(root==null)
            return 0;
		int ans[] = new int[1];
        ans[0]=1;
        solve(root,ans);
        return ans[0];
	}
    
    public static Node solve(TreeNode<Integer> root,int []ans)
    {
        if(root==null)
            return new Node(Integer.MAX_VALUE,Integer.MIN_VALUE,0,true);
        if(root.left==null && root.right==null)
            return new Node(root.data,root.data,1,true);
        Node leftNode = solve(root.left,ans);
        Node rightNode = solve(root.right,ans);
        if(leftNode.max<root.data && rightNode.min>root.data && leftNode.isBST && rightNode.isBST)
        {
            int total = leftNode.count+rightNode.count+1;
            ans[0] = Math.max(ans[0],total);
            return new Node(Math.min(root.data,leftNode.min),Math.max(root.data,rightNode.max),total,true);
        }
        return new Node(root.data,root.data,1,false);
    }
       
}