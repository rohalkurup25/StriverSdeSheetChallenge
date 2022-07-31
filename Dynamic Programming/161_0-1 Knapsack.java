import java.util.*;

public class Solution {
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int dp[][] = new int[n+1][w+1];
        for(int arr[] :dp)
            Arrays.fill(arr,-1);
		return solve(values,weights,n-1,w,dp);
	}
    
    public static int solve(ArrayList<Integer> values, ArrayList<Integer> weights, int i, int w,int [][]dp)
    {if(i<0)
        return 0;
        if(i==0)
        {
            if(w>=weights.get(0))
                return values.get(0);
        }
        if(dp[i][w]!=-1)
            return dp[i][w];
        int take = 0;
        if(w>=weights.get(i))
            take = values.get(i)+solve(values,weights,i-1,w-weights.get(i),dp);
        int notTake = solve(values,weights,i-1,w,dp);
        
        return dp[i][w]=Math.max(take,notTake);
    }
}