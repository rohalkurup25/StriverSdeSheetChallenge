import java.util.*;
public class Solution {

	public static int palindromePartitioning(String str) {
        int dp[] = new int[str.length()];
        Arrays.fill(dp,-1);
	    return solve(str,0,str.length(),dp)-1;
	}
    
    
    public static int solve(String s,int i, int n,int []dp)
    {
        if(i==n)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int min = Integer.MAX_VALUE;
        for(int k=i;k<n;k++)
        {
            if(isPalindrome(s,i,k))
            {
                int cost = 1+solve(s,k+1,n,dp);
                min =  Math.min(cost,min);
            }
        }
        return dp[i] = min;
    }
    
    public static boolean isPalindrome(String str,int i, int j)
    {
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }
}