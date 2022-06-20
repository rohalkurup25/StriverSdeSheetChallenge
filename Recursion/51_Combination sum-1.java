import java.util.*;
public class Solution 
{
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) 
	{
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        solve(arr,0,k,list,ans);
        return ans;
    }
    
    public static void solve(ArrayList<Integer> arr,int i,int k, ArrayList<Integer> list,ArrayList<ArrayList<Integer>> ans)
    {
        if(i==arr.size())
        {
            if(k==0){
            ans.add(new ArrayList(list));
            }
            return;
        }

        list.add(arr.get(i));
        solve(arr,i+1,k-arr.get(i),list,ans);
        list.remove(list.size()-1);
 
        solve(arr,i+1,k,list,ans);
    }
}