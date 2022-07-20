 
 
/*************************************************************
	Following is the Binary Tree node structure
	class TreeNode<T> {
		public T data;
		public TreeNode<T> left;
		public TreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = right = null;
		}

};************************************************************/
import java.util.*;

public class Solution {
 
	public static TreeNode<Integer> preOrderTree(int[] preOrder) {
        int i[] = new int[1];
        return solve(preOrder,Integer.MAX_VALUE,i);
	}
    public static TreeNode<Integer> solve(int []arr,int bound, int i[])
    {
        if(i[0]==arr.length || arr[i[0]]>bound)
            return null;
        TreeNode<Integer> root = new TreeNode(arr[i[0]++]);
        root.left = solve(arr,root.data,i);
        root.right = solve(arr,bound,i);
        return root;
    }
}