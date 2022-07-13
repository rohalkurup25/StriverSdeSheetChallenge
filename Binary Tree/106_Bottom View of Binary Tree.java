/*********************************************

    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

*********************************************/
import java.util.*;

class Node
{
    BinaryTreeNode node;
    int host;
    Node(BinaryTreeNode node,int host)
    {
        this.node = node;
        this.host = host;
    }
}

public class Solution {
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
        ArrayList<Integer> ans = new ArrayList();
        HashMap<Integer,Integer> map = new HashMap();
        int arr[] = new int[2];
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(root,0));
        while(!queue.isEmpty())
        {
            Node queueNode = queue.remove();
            arr[0] = Math.min(arr[0],queueNode.host);
            arr[1] = Math.max(arr[1],queueNode.host);
            map.put(queueNode.host,queueNode.node.val);
            if(queueNode.node.left!=null){
                int host = queueNode.host-1;
                queue.add(new Node(queueNode.node.left,host));
            }
            if(queueNode.node.right!=null){
                int host = queueNode.host+1;
                queue.add(new Node(queueNode.node.right,host));
            }
        }
        for(int i=arr[0];i<=arr[1];i++)
        {
            ans.add(map.get(i));
        }
        return ans;
    }
}