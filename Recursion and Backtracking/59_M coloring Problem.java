import java.util.*;
public class Solution {
	public static String graphColoring(int[][] mat, int m) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList();
        for(int i=0;i<mat.length;i++)
            graph.add(new ArrayList());
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(i!=j && mat[i][j]==1)
                {
                    graph.get(i).add(j);
                }
            }
        }
        int color[] = new int[mat.length];
         if(solve(graph,0,mat.length,m,color))
             return "YES";
         return "NO";
	}
    
    public static boolean solve(ArrayList<ArrayList<Integer>> graph,int i,int n,int k,int []color)
    {
        if(i==n)
            return true;
        for(int ind=1;ind<=k;ind++)
        {
           if(isPossible(graph,i,ind,color))
           {
               color[i]=ind;
               if(solve(graph,i+1,n,k,color))
                   return true;
               color[i]=0;
           }
        }
        return false;
    }
    
    public static boolean isPossible(ArrayList<ArrayList<Integer>> graph,int i,int col,int []color)
    {
        for(int val : graph.get(i))
        {
            if(color[val]==col)
                return false;
        }
        return true;
    }
}