import java.util.*;
public class Solution {

    public static int cutLogs(int k, int n) {
        
        int dp[][] = new int[k+1][n+1];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        return solve(k,n,dp);
    }
    
    
    public static int solve(int e,int f,int dp[][])
    {
        if(e==1)
            return f;
        if(f==0 ||f==1)
            return f;
        if(dp[e][f]!=-1)
            return dp[e][f];
        int ans = Integer.MAX_VALUE;
        int low = 1;
        int high = f;
        while(low<=high)
        {
            int mid = (low+high)/2;
            int axeBreak = solve(e-1,mid-1,dp);
            int notBreak = solve(e,f-mid,dp);
            int temp = 1+Math.max(axeBreak,notBreak);
            if(notBreak>axeBreak)
                low = mid+1;
            else
                high = mid-1;
            ans = Math.min(temp,ans);
        }
        return dp[e][f] = ans;
    }

}