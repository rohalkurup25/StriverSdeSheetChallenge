/************************************************************
  
   Following is the TreeNode class structure
   
   class TreeNode<T> { 
        T data; 
        TreeNode<T> left;
        TreeNode<T> right;
  
        TreeNode(T data) { 
            this.data = data; 
            left = null; 
            right = null; 
        }
   }
    
 ************************************************************/
import java.util.*;
public class Solution {
	public static TreeNode<Integer> getTreeFromPostorderAndInorder(int[] postOrder, int[] inOrder) {
        if (inOrder == null || postOrder == null || inOrder.length != postOrder.length)
            return null;
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<inOrder.length;i++)
            map.put(inOrder[i],i);
        int n = inOrder.length;
        int po[] = new int[1];
        po[0] = n-1;
        return solve(inOrder,postOrder,0,n-1,po,map);
	}
    
   public static TreeNode<Integer> solve(int in[],int pos[],int start, int end,int po[], HashMap<Integer,Integer> map )
    {
        if(start>end ||po[0]<0 )
            return null;
       int element = pos[po[0]--];
       TreeNode<Integer> root = new TreeNode(element);
       int index = map.get(element);
      
       root.right = solve(in,pos,index+1,end,po,map);
       root.left = solve(in,pos,start,index-1,po,map);
       return root;
    }
}