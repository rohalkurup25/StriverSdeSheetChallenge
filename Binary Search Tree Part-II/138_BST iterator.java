/*
    Definition of Node class for reference

    class TreeNode<T> 
    {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

*/
import java.util.*;
public class Solution {

    static class BSTIterator{
        Stack<TreeNode<Integer>> stack;   
        TreeNode<Integer> root ;
        BSTIterator(TreeNode<Integer> root){
            stack = new Stack();
            this.root = root;
           initial(stack,root);
        }

        int next(){
            if(hasNext())
            {
                TreeNode<Integer> node = stack.pop();
                initial(stack,node.right);
                return node.data;
            }
            return -1;
        }
        
        public static void initial(Stack<TreeNode<Integer>> stack,TreeNode<Integer> root)
        {
            while(root!=null)
            {
                stack.add(root);
                root = root.left;
            }
        }

        boolean hasNext(){
            return !(stack.isEmpty());
        }
    }
}

/*
    Your BSTIterator object will be instantiated and called as such:
    BSTIterator iterator = new BSTIterator(root);
    while(iterator.hasNext())
    {
       print(iterator.next()+" ");
    }
*/