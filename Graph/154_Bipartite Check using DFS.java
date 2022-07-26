import java.util.*;

public class Solution {

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
      ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<edges.size();i++){
                adj.add(new ArrayList());
        }

        for(int i=0;i<edges.size();i++)
        {
            for(int j=0;j<edges.get(i).size();j++)
            {
                if(edges.get(i).get(j)==1)
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int color[] = new int[edges.size()];
        Arrays.fill(color,-1);
        for(int i=0;i<edges.size();i++)
        {
            if(color[i]==-1)
            {
            if(!dfs(adj,color,i))
            {
                return false;
            }
            }
        }
        return true;
    }
    
    
    public static boolean dfs(ArrayList<ArrayList<Integer>> edges,int color[],int i)
    {
        if(color[i]==-1)
            color[i]=1;
        for(Integer it : edges.get(i))
        {
            if(color[it]==-1)
            {
                color[it] = 1-color[i];
                if(!dfs(edges,color,it))
                    return false;
            }
            else if(color[it]==color[i])
                return false;
        }
         return true;   
    }
}