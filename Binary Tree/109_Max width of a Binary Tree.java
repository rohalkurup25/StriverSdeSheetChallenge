/************************************************************

    Following is the TreeNode class structure

    class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	   }
	}


************************************************************/
import java.util.*;
public class Solution {
	public static int getMaxWidth(TreeNode root) {
		if(root==null)
            return 0;
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int siz = queue.size();
            ans = Math.max(ans,siz);
            for(int i=0;i<siz;i++)
            {
                TreeNode node = queue.remove();
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
        }
        return ans;
	}
}