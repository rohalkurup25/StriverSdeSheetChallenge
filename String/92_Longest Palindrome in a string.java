public class Solution {	
	public static String longestPalinSubstring(String str) {
        int max = 1;
        int n = str.length();
        if(n==0)
            return "";
        String ans = str.charAt(0)+"";
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            dp[i][i] = 1;
        }
        for(int i=0;i<n-1;i++)
        {
            if(str.charAt(i)==str.charAt(i+1)){
                if(max<2)
                {
                    max=2;
                    ans = str.substring(i,i+2);
                }
                dp[i][i+1] = 1;
            }
        }
        for(int k=3;k<=n;k++)
        {
            for(int i=0;i<n-k+1;i++)
            {
                int j = i+k-1;
                if(dp[i+1][j-1]==1 && str.charAt(i)==str.charAt(j))
                {
                    if(max<k)
                    {
                        max = k;
                        ans = str.substring(i,i+k);
                    }
                    dp[i][j]=1;
                }
                
            }
        }
        return ans;
        
    }
}