import java.util.ArrayList;
public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    boolean vis[] = new boolean[n+1];
    boolean dfsVis[] = new boolean[n+1];
      ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=n;i++){
            ArrayList<Integer> ar=new ArrayList<Integer>();
            adj.add(ar);
        }
        for(int i=0;i<edges.size();i++){
            ArrayList<Integer> temp=edges.get(i);
            int a=temp.get(0);
            int b=temp.get(1);
            ArrayList<Integer> temp2=adj.get(a);
            temp2.add(b);
        }
    for(int i=0;i<=n;i++)
    {
        if(!vis[i])
        if(dfs(adj,vis,dfsVis,i))
            return true;
    }
      return false;
  }
    
    
    public static boolean dfs(ArrayList<ArrayList<Integer>> edges,boolean vis[],boolean dfsVis[],int vertex)
    {
        vis[vertex] = true;
        dfsVis[vertex] = true;

        for(int child: edges.get(vertex))
        {
            if(!vis[child]){
                if(dfs(edges,vis,dfsVis,child))
                    return true;
            }
            else if(dfsVis[child])
                return true;
        }
        dfsVis[vertex] = false;    
        return false;
    }
}