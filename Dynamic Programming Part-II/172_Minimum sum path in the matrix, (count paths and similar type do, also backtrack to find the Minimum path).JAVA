import java.util.*;
public class Solution {
    public static int minSumPath(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for(int x[]:dp)
            Arrays.fill(x,-1);
    	return solve(grid,grid.length-1,grid[0].length-1,dp);
    }
    
    
    public static int solve(int  [][]arr,int i,int j,int [][]dp)
    {
        if(i==0 && j==0)
            return arr[0][0];
        if(i<0 || j<0 )
            return Integer.MAX_VALUE;
          if(dp[i][j]!=-1)
              return dp[i][j];
        int left =solve(arr,i,j-1,dp);
        int up = solve(arr,i-1,j,dp);
        return dp[i][j]= Math.min(up,left)+arr[i][j];
    }
}