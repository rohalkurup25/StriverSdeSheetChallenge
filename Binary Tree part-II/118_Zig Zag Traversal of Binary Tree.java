/*
	Following is the class used to represent the object/node of the Binary Tree

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}
*/
import java.util.*;
public class Solution {
	public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
	    List<Integer> ans = new ArrayList();
        List<Integer> list;
        int k=0;
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList();
        if(root==null)
            return ans;
        queue.add(root);
        while(!queue.isEmpty())
        {
            int siz = queue.size();
            list = new ArrayList();
            for(int i=0;i<siz;i++)
            {
                BinaryTreeNode<Integer> node = queue.remove();
                list.add(node.data);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            if((k&1)==1)
            {
                Collections.reverse(list);
            }
            for(int x:list)
                ans.add(x);
            k++;
        }
        return ans;
	}
}