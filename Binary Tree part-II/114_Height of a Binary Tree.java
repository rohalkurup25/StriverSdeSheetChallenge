import java.util.*;
class Node
{
    int left;
    int right;
    int ht;
    Node(int left,int right,int ht)
    {
        this.left= left;
        this.right = right;
        this.ht = ht;
    }
}
public class Solution {
	public static int heightOfTheTree(int[] inorder, int[] levelOrder, int N){
        if(N==0)
            return 0;
        int maxHt = 0;
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
		Queue<Node> queue = new LinkedList();
        queue.add(new Node(0,N-1,0));
        for(int i=0;i<N;i++)
        {
            int root = levelOrder[i];
            int index = map.get(root);
            Node node = queue.remove();
            if(index>node.left)
            {
                queue.add(new Node(node.left,index-1,node.ht+1));
                maxHt = Math.max(maxHt,node.ht+1);
            }
            if(index<node.right)
            {
                queue.add(new Node(index+1,node.right,node.ht+1));
                maxHt = Math.max(maxHt,node.ht+1);
            }
        }
        return maxHt;
	}
}