import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        boolean vis[] = new boolean[v+1];
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<v;i++){
            map.put(i,new ArrayList<>());
        }
        
        for(int i=0;i<edges.size();i++){
            map.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            map.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }

        for(int i=0;i<v;i++)
        {
            if(!vis[i])
            {
                ArrayList<Integer> list = new ArrayList();
                dfs(map,i,vis,list);
                Collections.sort(list);
                ans.add(new ArrayList(list));
            }
        }
       return ans;
    }
    
    public static void dfs(HashMap<Integer,ArrayList<Integer>> map,int vertex,boolean vis[],ArrayList<Integer> list)
    {
        list.add(vertex);
        vis[vertex] = true;
        for(Integer child : map.get(vertex))
        {
            if(!vis[child])
                dfs(map,child,vis,list);
        }
    }
}