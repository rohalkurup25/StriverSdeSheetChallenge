import java.util.*;

public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        int dp[][] = new int[n][k+1];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        return solve(arr,n-1,k,dp);
    }
    
    public static boolean solve(int []arr,int i,int sum,int [][]dp)
    {
        if(sum==0)
            return true;
        if(i<0)
            return false;
        if(dp[i][sum]!=-1)
        {
            if(dp[i][sum]==1)
                return true;
            else
                return false;
        }
        boolean take = false;
        if(arr[i]<=sum)
            take = solve(arr,i-1,sum-arr[i],dp);
        boolean notTake = solve(arr,i-1,sum,dp);
        boolean res =  take || notTake;
        if(res)
            dp[i][sum] = 1;
        else
            dp[i][sum] = 0;
        return res;
    }
}