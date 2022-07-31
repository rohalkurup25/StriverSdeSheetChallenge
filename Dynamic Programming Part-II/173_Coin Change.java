import java.util.*;
public class Solution {

	public static long countWaysToMakeChange(int denominations[], int value){
        long dp[][] = new long[denominations.length][value+1];
        for(long x[]:dp)
        Arrays.fill(x,-1);
        return solve(denominations,value,0,dp);
	}
       
    public static long solve(int []arr,int wt,int i,long [][]dp)
    {
        if(wt==0)
            return 1;
        if(i==arr.length)
            return 0;
        if(dp[i][wt]!=-1)
            return dp[i][wt];
        long notTake = solve(arr,wt,i+1,dp);
        long take = 0;
        if(wt>=arr[i])
            take = solve(arr,wt-arr[i],i,dp);
        return dp[i][wt] = take+notTake;
    }
	
}