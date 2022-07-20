/*
    ----------------- Binary Tree node class for reference -----------------

    class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> left;
        public BinaryTreeNode<T> right;
        public BinaryTreeNode<T> next;

        BinaryTreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
            next = null;
        }
    };

*/
import java.util.*;

public class Solution {
    public static void connectNodes(BinaryTreeNode<Integer> root) {
       Queue<BinaryTreeNode<Integer>> queue = new LinkedList();
       BinaryTreeNode<Integer> dummy ;
        if(root==null)
            return;
        queue.add(root);
       while(!queue.isEmpty())
       {
           int siz = queue.size();
           dummy = new BinaryTreeNode(0);
           for(int i=0;i<siz;i++)
           {
               BinaryTreeNode node = queue.remove();
               dummy.next = node;
               dummy = node;
               if(node.left!=null)
                   queue.add(node.left);
               if(node.right!=null)
                   queue.add(node.right);
           }
       }
    }
}