import java.util.*;
public class Solution {
   static class Node
    {
        int v;
        int parent;
        Node(int v,int parent)
        {
            this.v = v;
            this.parent = parent;
        }
    }
    public static String cycleDetection(int[][] edges, int n, int m) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList());
        }
        for(int i=0;i<edges.length;i++)
        {
            int a=edges[i][0];
            int b=edges[i][1];
            ArrayList<Integer> temp=adj.get(a);
            temp.add(b);
            ArrayList<Integer> temp2=adj.get(b);
            temp2.add(a);
        }        
        boolean vis[] = new boolean[n+1];
        for(int i=1;i<=n;i++)
        {
            if(!vis[i])
            {
                if(bfs(adj,vis,i))
                    return "Yes";
            }
        }
        return "No";
    }
    
    
    public static boolean bfs(ArrayList<ArrayList<Integer>> adj,boolean []vis,int vertex)
    {
        vis[vertex] = true;
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(vertex,-1));
        while(!queue.isEmpty())
        {
            Node node = queue.remove();
            for(int childs : adj.get(node.v))
            {
                if(!vis[childs])
                {
                    vis[childs] = true;
                    queue.add(new Node(childs,node.v));
                }
                else if(childs!=node.parent)
                    return true;
            }
        }
        return false;
    }
}