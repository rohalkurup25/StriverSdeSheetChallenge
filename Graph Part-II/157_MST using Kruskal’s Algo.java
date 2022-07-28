import java.util.*;
public class Solution {
    
    public static int getParent(int v,int parent[])
    {
        if(v==parent[v])
            return v;
        return parent[v] = getParent(parent[v],parent);
    }
    
    public static void union(int u , int v,int rank[],int parent[])
    {
        int n1 = getParent(u,parent);
        int n2 = getParent(v,parent);
        if(rank[n1]>rank[n2])
            parent[n2] = n1;
        else if(rank[n2]>rank[n1])
            parent[n1] = n2;
        else
        {
            parent[n2] = n1;
            rank[n1]++;
        }
    }
    
    
    public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        Collections.sort(graph,(n1,n2)->n1.get(2)-n2.get(2));
        int parent[] = new int[n+1];
        int rank[] = new int[n+1];
        for(int i=0;i<=n;i++)
            parent[i] = i;
        int mst = 0;
        for(ArrayList<Integer> list : graph)
        {
            int c1 = list.get(0);
            int c2 = list.get(1);
            int p1 = getParent(c1,parent);
            int p2 = getParent(c2,parent);
            if(p1==p2)
                continue;
            else
            {
                mst+=list.get(2);
                union(c1,c2,rank,parent);
            }
        }
        return mst;
    }
}