/*************************************************************
    Following is the Binary Tree node structure

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
    public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode <Integer> root, int key) {

        ArrayList<Integer>  ans = new ArrayList();
        BinaryTreeNode <Integer> root1 = root;
        BinaryTreeNode <Integer> root2 = root;
        int pred = -1;
        int succ = -1;
        while(root1!=null)
        {
            if(root1.data<=key)
                root1 = root1.right;
            else
            {
                succ = root1.data;
                root1 = root1.left;
            }
        }
        while(root2!=null)
        {
            if(root2.data>=key)
                root2 = root2.left;
            else
            {
                pred = root2.data;
                root2 = root2.right;
            }
        }
        ans.add(pred);
        ans.add(succ);
        return ans;
    }

}