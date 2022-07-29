import java.util.*;
public class Solution {
    static class Node
    {
        int u;
        int v;
        int wt;
        Node(int u,int v,int wt)
        {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }
    
    
    static int bellmonFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<Node> graph = new ArrayList();
        for(ArrayList<Integer> it : edges)
            graph.add(new Node(it.get(0),it.get(1),it.get(2)));
        int dist[] = new int[n+1];
        Arrays.fill(dist,1000000000);
        dist[src] = 0;
        for(int i=0;i<n-1;i++)
        {
            for(Node node : graph)
            {
                if(dist[node.u]!=1000000000 && dist[node.u]+node.wt < dist[node.v])
                    dist[node.v] = dist[node.u]+node.wt;
            }
        }
        return dist[dest];
    }
    
}