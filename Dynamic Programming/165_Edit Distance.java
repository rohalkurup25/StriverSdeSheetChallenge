import java.util.*;
public class Solution {

    public static int editDistance(String str1, String str2) {
        int dp[][] = new int[str1.length()][str2.length()];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        return solve(str1,str2,str1.length()-1,str2.length()-1,dp);
    }
    
    
    public static int solve(String s1,String s2,int i,int j,int [][]dp)
    {
        if(i<0)
            return j+1;
        if(j<0)
            return i+1;
         if(dp[i][j]!=-1)
             return dp[i][j];
       if(s1.charAt(i)==s2.charAt(j))
           return dp[i][j] = solve(s1,s2,i-1,j-1,dp);
        else
        {
            return dp[i][j] = 1+Math.min(solve(s1,s2,i,j-1,dp),Math.min(solve(s1,s2,i-1,j,dp),solve(s1,s2,i-1,j-1,dp)));
        }
        
    }
}