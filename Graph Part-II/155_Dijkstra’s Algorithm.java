import java.util.*;

  class Node
    {
        int val;
        int wt;
        Node(){}
        Node(int val,int wt)
        {
            this.val = val;
            this.wt = wt;
        }
    }
	
public class Solution {
	public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int vertices, int edges, int source){
        ArrayList<Integer> ans  = new ArrayList();
        ArrayList<ArrayList<Node>> graph = new ArrayList();
        for(int i=0;i<vertices;i++)
        {
            graph.add(new ArrayList());
        }
        for(ArrayList<Integer> list : vec)
        {
            graph.get(list.get(0)).add(new Node(list.get(1),list.get(2)));
            graph.get(list.get(1)).add(new Node(list.get(0),list.get(2)));
        }

        int dist[] = new int[vertices+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source]=0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>((n1,n2)->n1.wt-n2.wt);
        pq.add(new Node(source,0));
        while(!pq.isEmpty())
        {
            Node node = pq.poll();
            for(Node child : graph.get(node.val))
            {
                if(dist[child.val]==Integer.MAX_VALUE || dist[child.val]>(dist[node.val]+child.wt))
                {
                    dist[child.val] = dist[node.val]+child.wt;
                    pq.add(new Node(child.val,dist[child.val]));
                }
            }
        }
        for(int i=0;i<vertices;i++)
            ans.add(dist[i]);
        return ans;
	}
}