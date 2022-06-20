import java.util.*;

public class Solution 
{
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
    {
          Collections.sort(arr);
          ArrayList<ArrayList<Integer>> ans = new ArrayList();
          ArrayList<Integer> list = new ArrayList();
          solve(arr,0,target,n,list,ans);
          return ans;
    }
        public static void solve(ArrayList<Integer> arr,int i,int k,int n, ArrayList<Integer> list,ArrayList<ArrayList<Integer>> ans)
    {
        if(k==0)
        {
            ans.add(new ArrayList(list));
            return;
        }
        for(int ind = i;ind<n;ind++){
        if(ind>i && arr.get(ind)==arr.get(ind-1))
            continue;
        if(arr.get(ind)<=k){
        list.add(arr.get(ind));
        solve(arr,ind+1,k-arr.get(ind),n,list,ans);
        list.remove(list.size()-1);
          }
        }
    }
}