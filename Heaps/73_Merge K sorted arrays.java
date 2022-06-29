import java.util.*;

public class Solution 
{
    
    static class Node
    {
        int index;
        int listIndex;
        int val;
        
        Node(int index,int val,int listIndex)
        {
            this.index = index;
            this.val = val;
            this.listIndex = listIndex;
        }
    }
    
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		PriorityQueue<Node> pq = new PriorityQueue<Node>((node1,node2)->node1.val-node2.val);
        for(int i=0;i<k;i++){
            int value = kArrays.get(i).get(0);
            pq.add(new Node(0,value,i));
            }
        ArrayList<Integer> ans = new ArrayList();
        while(!pq.isEmpty())
        {
            Node node = pq.remove();
            if(node.index+1<kArrays.get(node.listIndex).size())
                pq.add(new Node(node.index+1,kArrays.get(node.listIndex).get(node.index+1),node.listIndex));
            ans.add(node.val);
        }
        return ans;
	}
}