import java.util.*;
public class Solution {
    public static ArrayList<Integer> BFS(int vertex, int edges[][]){
        // WRITE YOUR CODE HERE
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<vertex; i++) adj.add(new ArrayList());
        
        for(int i=0; i<edges[0].length; i++)
        {
            adj.get(edges[0][i]).add(edges[1][i]);
            adj.get(edges[1][i]).add(edges[0][i]);            
        }
        
       for(int i=0; i<vertex; i++) Collections.sort(adj.get(i));
        
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[vertex];
        
        for(int i=0; i<vertex; i++)
        {
            if(!visited[i])
            {
                bfs(i, adj, visited, ans);
            }
        }
        return ans;
    }
    public static void bfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while(!q.isEmpty())
        {
            for(int i=q.size(); i>0; i--)
            {
                int currentNode = q.poll();
                ans.add(currentNode);
                for(int adjacentNode : adj.get(currentNode))
                {
                     if(!visited[adjacentNode])
                     {
                         visited[adjacentNode] = true;
                         q.add(adjacentNode); 
                     }
                }
            }
        }
    }
}