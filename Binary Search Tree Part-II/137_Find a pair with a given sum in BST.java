/*************************************************************
    
    Following is the Binary Tree node structure:

    class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	   }
    }
*************************************************************/
import java.util.*;

public class Solution {
	public static boolean pairSumBst(BinaryTreeNode root, int k) {
        Stack<BinaryTreeNode> stack1 = new Stack();
        Stack<BinaryTreeNode> stack2 = new Stack();
		BinaryTreeNode root1 = root;
        BinaryTreeNode root2 = root;
        addLeftNode(root1,stack1);
        addRightNode(root2,stack2);
        int asc = getNextAsc(stack1);
        int desc = getNextDesc(stack2);
        while(asc!=-1 && desc!=-1 && asc!=desc)
        {
            int sum = asc+desc;
            if(sum==k)
                return true;
            else if(sum>k)
                desc = getNextDesc(stack2);
            else
                asc = getNextAsc(stack1);
        }
        return false;
	}
    
    public static void addLeftNode(BinaryTreeNode root,Stack<BinaryTreeNode> stack)
    {
        while(root!=null)
        {
            stack.push(root);
            root = root.left;
        }
    }
    
    public static void addRightNode(BinaryTreeNode root,Stack<BinaryTreeNode> stack)
    {
        while(root!=null)
        {
            stack.push(root);
            root = root.right;
        }
    }
    
    public static int getNextAsc(Stack<BinaryTreeNode> stack)
    {
        int ans = -1;
        if(!stack.isEmpty())
        {
            BinaryTreeNode node = stack.pop();
            ans = node.data;
            addLeftNode(node.right,stack);
        }
        return ans;
    }

    public static int getNextDesc(Stack<BinaryTreeNode> stack)
    {
        int ans = -1;
        if(!stack.isEmpty())
        {
            BinaryTreeNode node = stack.pop();
            ans = node.data;
            addRightNode(node.left,stack);
        }
        return ans;
    }
}
