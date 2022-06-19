import java.util.*;
public class Solution {
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        Arrays.sort(arr);
        solve(arr,0,ans,list);
        return ans;
    }
    
    public static void solve(int []arr,int i,ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list)
    {
        ans.add(new ArrayList(list));
        for(int ind = i;ind<arr.length;ind++)
        {
            if(ind>i && arr[ind]==arr[ind-1])
                continue;
            list.add(arr[ind]);
            solve(arr,ind+1,ans,list);
            list.remove(list.size()-1);
        }
    }

}