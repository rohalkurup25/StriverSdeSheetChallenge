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
    public static TreeNode<Integer> buildBinaryTree(ArrayList<Integer>  inorder, ArrayList<Integer>  preorder) 
    {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<inorder.size();i++)
            map.put(inorder.get(i),i);
        int in[] = new int[1];
        return solve(inorder,preorder,in,0,inorder.size()-1,map);
    }
    
    
    public static TreeNode<Integer> solve(ArrayList<Integer>  inorder, ArrayList<Integer>  preorder,int in[],int start,int end, HashMap<Integer,Integer> map )
    {
        if(in[0]==inorder.size() || start>end)
            return null;
        TreeNode<Integer> root = new TreeNode(preorder.get(in[0]));
        int index = map.get(root.data);
        in[0]++;
        root.left = solve(inorder,preorder,in,start,index-1,map);
        root.right = solve(inorder,preorder,in,index+1,end,map);
        return root;
    }
    
    
    
    
    
    
    
    
}