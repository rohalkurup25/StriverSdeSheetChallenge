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
    static class Node
    {
        int x;
        int y;
        int val;
        int first;
        Node(int x,int y,int val,int first)
        {
            this.x = x;
            this.y = y;
            this.val = val;
            this.first = first;
        }
    }
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        ArrayList<Integer> ans = new ArrayList();
        ArrayList<Node> temp = new ArrayList();
        solve(root,0,0,temp,new int[]{0});
        Collections.sort(temp,(o1,o2)->{
            if(o1.x==o2.x)
            {
                if(o1.y==o2.y)
                {
                    return o1.first-o2.first;
                }
               return o1.y-o2.y;
            }
            return o1.x-o2.x;
        });
        for(Node node : temp)
            ans.add(node.val);
        return ans;
    }
    
    public static void solve(TreeNode<Integer> root,int x,int y,ArrayList<Node> temp,int []arr)
    {
        if(root==null)
            return;
        arr[0]++;
        solve(root.left,x-1,y+1,temp,arr);
        solve(root.right,x+1,y+1,temp,arr);
        temp.add(new Node(x,y,root.data,arr[0]));
    }
}