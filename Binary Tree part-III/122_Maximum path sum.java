/************************************************************

    Following is the Tree node structure
	
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
public class Solution {
    
    
	public static long findMaxSumPath(TreeNode root) {
		long sum[] = new long[1];
        solve(root,sum);
        if(root==null || root.left==null || root.right==null)
            return -1;
        return sum[0];
	}
    
    public static long solve(TreeNode root,long sum[])
    {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return root.data;
        long leftValue = solve(root.left,sum);
        long rightValue= solve(root.right,sum);
        sum[0] = Math.max(sum[0],leftValue+rightValue+root.data);
        long max = Math.max(leftValue,rightValue)+root.data;
        return max;
    }
}