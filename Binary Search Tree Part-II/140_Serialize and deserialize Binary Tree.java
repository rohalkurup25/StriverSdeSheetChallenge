/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/
import java.util.*;

public class Solution 
{
    public static String serializeTree(TreeNode<Integer> root)
    {
       StringBuilder ans = new StringBuilder("");
       if(root==null)
           return ans.toString();
       Queue<TreeNode<Integer>> queue = new LinkedList();
       queue.add(root);
       ans.append(root.data);
       while(!queue.isEmpty())
       {
           TreeNode<Integer> node = queue.remove();
           if(node.left!=null)
           {
               int val = node.left.data;
               ans.append(","+val);
               queue.add(node.left);
           }
           else
               ans.append(",#");
           if(node.right!=null)
           {
               int val = node.right.data;
               ans.append(","+val);
               queue.add(node.right);
           }
           else
               ans.append(",#");
       }
        return ans.toString();
    }
    
    public static TreeNode<Integer> deserializeTree(String str)
    {
     String s[] = str.split(",");
     if(s.length==0 || s[0].equals(""))
         return null;

     TreeNode<Integer> root = new TreeNode(Integer.parseInt(s[0]));
     Queue<TreeNode<Integer>> queue = new LinkedList();
     queue.add(root);
     for(int i=1;i<s.length;i++)
     {
        TreeNode<Integer> node =queue.remove();
        if(!s[i].equals("#"))
        {
            node.left = new TreeNode<Integer>(Integer.parseInt(s[i]));
            queue.add(node.left);
        }
        if(!s[++i].equals("#"))
        {
            node.right = new TreeNode<Integer>(Integer.parseInt(s[i]));
            queue.add(node.right);
        }
     }
     
     return root;    }
}