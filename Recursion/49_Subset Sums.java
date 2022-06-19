import java.util.*;
public class Solution {
    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> ans = new ArrayList();
        solve(num,0,ans,0);
        Collections.sort(ans);
        return ans;
    }

    public static void solve(int []nums,int i,ArrayList<Integer> ans,int sum )
    {
        if(i==nums.length)
        {
            ans.add(sum);
            return;
        }
        solve(nums,i+1,ans,sum);
        solve(nums,i+1,ans,sum+nums[i]);
    }
}