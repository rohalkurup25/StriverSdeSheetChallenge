
/*************************************************************
 class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

*************************************************************/


public class Solution {
	
	public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> head[] =new BinaryTreeNode[1];
        BinaryTreeNode<Integer> tail[] =new BinaryTreeNode[1];
        solve(root,head,tail);
        return head[0];
	}
    
    
    public static void solve(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> head[],BinaryTreeNode<Integer> tail[])
    {
        if(root==null)
            return;
        solve(root.left,head,tail);
        BinaryTreeNode<Integer> node = new BinaryTreeNode(root.data);
        if(head[0]==null)
        {
            head[0] = tail[0] = node;
        }
        else
        {
            tail[0].right = node;
            node.left= tail[0];
            tail[0] = node;
        }
        solve(root.right,head,tail);
    }
	

}