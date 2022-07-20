/****************************************************************

    Following is the class structure of the TreeNode class:

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


*****************************************************************/

import java.util.ArrayList;

public class Solution {
    public static TreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
        return solve(arr,0,n-1);
    }
    
    public static TreeNode<Integer> solve(ArrayList<Integer> arr,int start, int end)
    {
        if(start>end)
            return null;
        int mid = (start+end)/2;
        TreeNode<Integer> root=  new TreeNode(arr.get(mid));
        root.left = solve(arr,start,mid-1);
        root.right = solve(arr,mid+1,end);
        return root;
    }
}