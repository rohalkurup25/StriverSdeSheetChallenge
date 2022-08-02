import java.util.*;

public class Solution {
	public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        solve(arr,list,ans,0);
        return ans;
	}
    
    
    public static void solve(ArrayList<Integer> arr,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> ans, int i)
    {
        if(i==arr.size())
        {
            ans.add(new ArrayList(list));
            return;
        }
        list.add(arr.get(i));
        solve(arr,list,ans,i+1);
        list.remove(list.size()-1);
        solve(arr,list,ans,i+1);
    }
}
