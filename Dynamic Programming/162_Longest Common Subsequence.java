import java.util.*;
public class Solution {

	public static int lcs(String s, String t) {
        
        int dp[][] = new int[s.length()][t.length()];
        for(int x[]:dp)
            Arrays.fill(x,-1);
		return solve(s,t,s.length()-1,t.length()-1,dp);
    }
    
    
    public static int solve(String s,String t,int i,int j,int [][]dp)
    {
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s.charAt(i)==t.charAt(j))
            return dp[i][j] =  1+solve(s,t,i-1,j-1,dp);
        else
            return dp[i][j] = Math.max(solve(s,t,i-1,j,dp),solve(s,t,i,j-1,dp));
    }

}