/*

	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T val;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

*/

import java.util.*;

public class Solution {

  public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
    ArrayList<Integer> ans = new ArrayList();
    Queue<BinaryTreeNode> queue = new LinkedList();
      if(root==null)
          return ans;
      queue.add(root);
      while(!queue.isEmpty())
      {
          BinaryTreeNode node = queue.remove();
          ans.add(node.val);
          if(node.left!=null)
              queue.add(node.left);
          if(node.right!=null)
              queue.add(node.right);
      }
      return ans;
  }

}