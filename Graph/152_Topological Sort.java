import java.util.*;

public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
      ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<v;i++){
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
        ArrayList<Integer> ans = new ArrayList();
        Queue<Integer> queue = new LinkedList();
        int [] inorder = new int[v];
        for(int i=0;i<adj.size();i++)
        {
            for(int x: adj.get(i))
                inorder[x]++;
        }
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==0)
                queue.add(i);
        }
        while(!queue.isEmpty())
        {
            int node = queue.remove();
            ans.add(node);
            for(int it : adj.get(node))
            {
                inorder[it]--;
                if(inorder[it]==0)
                    queue.add(it);
            }
        }
        return ans;
    }
}