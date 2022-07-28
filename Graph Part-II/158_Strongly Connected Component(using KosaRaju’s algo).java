import java.util.*;
public class Solution {

    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        List<List<Integer>> graph = new ArrayList();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList());
        for(int edge[]:edges)
            graph.get(edge[0]).add(edge[1]);
        Stack<Integer> stack = new Stack();
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i])
            topo(stack,graph,i,vis);
        }
        ArrayList<ArrayList<Integer>> transpose = new ArrayList();
        for(int i=0;i<n;i++)
            transpose.add(new ArrayList());        
        vis = new boolean[n];
        for(int edge[]:edges)
            transpose.get(edge[1]).add(edge[0]);
        while(!stack.isEmpty())
        {
            int node = stack.pop();
            if(!vis[node])
            {
                list = new ArrayList();
                revDfs(list,node,transpose,vis);
                ans.add(new ArrayList(list));
            }
        }
        return ans;
    }
    
    public static void topo(Stack<Integer> stack,List<List<Integer>> graph,int node,boolean vis[])
    {
        vis[node]=true;
        for(Integer it:graph.get(node))
        {
            if(!vis[it])
                topo(stack,graph,it,vis);
        }
        stack.push(node);
    }
    
    
    public static void revDfs(ArrayList<Integer> list,int node,ArrayList<ArrayList<Integer>> graph,boolean []vis)
    {
        list.add(node);
        vis[node] = true;
        for(int it : graph.get(node))
        {
            if(!vis[it])
                revDfs(list,it,graph,vis);
        }
    }
    
}