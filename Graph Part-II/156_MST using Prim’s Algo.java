import java.util.*;

public class Solution 
{
    static class Node
    {
        int v;
        int wt;
        Node(int v, int wt)
        {
            this.v = v;
            this.wt = wt;
        }
    }
    
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        ArrayList<ArrayList<Node>> graph = new ArrayList();
        for(int i=0;i<=n;i++)
            graph.add(new ArrayList());
        for(ArrayList<Integer> adj : g){
            graph.get(adj.get(0)).add(new Node(adj.get(1),adj.get(2)));
            graph.get(adj.get(1)).add(new Node(adj.get(0),adj.get(2)));
        }
        int key[] = new int[n+1];
        Arrays.fill(key,Integer.MAX_VALUE);
        key[1] = 0;
        boolean mst[] = new boolean[n+1];
        int parent[] = new int[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<Node>((n1,n2)->n1.wt-n2.wt);
        pq.add(new Node(1,0));
        while(!pq.isEmpty())
        {
            Node node = pq.remove();
            mst[node.v] = true;
            for(Node it : graph.get(node.v))
            {
                if(!mst[it.v] && key[it.v]>it.wt)
                {
                    parent[it.v] = node.v;
                    key[it.v] = it.wt;
                    pq.add(new Node(it.v,key[it.v]));
                }
            }
        }
        
        for(int i=2;i<=n;i++)
        {
            ArrayList<Integer> list=  new ArrayList();
            list.add(parent[i]);
            list.add(i);
            list.add(key[i]);
            ans.add(list);
        }
        return ans;
    }
}