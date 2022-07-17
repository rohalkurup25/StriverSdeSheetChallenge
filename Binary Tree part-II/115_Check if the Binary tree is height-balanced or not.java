/*************************************************************

Following is the Binary Tree node structure

class BinaryTreeNode<T> 
{
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

*************************************************************/
class Node
{
    int ht;
    boolean isBalanced;
    
    Node(int ht,boolean isBalanced)
    {
        this.ht = ht;
        this.isBalanced = isBalanced;
    }
}
public class Solution {

	public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
		Node node = solve(root);
        return node.isBalanced;
	}
     
    public static Node solve(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            Node node = new Node(0,true);
            return node;
        }
        
        Node left = solve(root.left);
        Node right = solve(root.right);
        int ht = Math.max(left.ht,right.ht)+1;
        if(Math.abs(left.ht-right.ht)>1 || !left.isBalanced || !right.isBalanced)
            return new Node(ht,false);
        return new Node(ht,true);
    }
    
}