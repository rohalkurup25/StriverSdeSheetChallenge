import java.util.Arrays;
public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
        int dp[][] = new int[N][N];

        for(int i=N-1;i>=1;i--)
        {
            for(int j=i+1;j<N;j++)
            {
                int min = Integer.MAX_VALUE;
                 for(int k=i;k<j;k++)
                {
                    int step  = arr[i-1]*arr[k]*arr[j] + dp[i][k]+dp[k+1][j];
                    if(step<min)
                        min = step;
                }
                 dp[i][j]=min;               
            }
        }
        return dp[1][N-1];
	}
    
    public static int solve(int []arr,int i,int j,int [][]dp)
    {
        if(i==j)
            return 0;
        int min = Integer.MAX_VALUE;
        if(dp[i][j]!=-1)
            return dp[i][j];
        for(int k=i;k<j;k++)
        {
            int step  = arr[i-1]*arr[k]*arr[j] + solve(arr,i,k,dp)+solve(arr,k+1,j,dp);
            if(step<min)
                min = step;
        }
        return dp[i][j]=min;
    }
}