import java.util.ArrayList;

public class Solution {
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        int ans = rack.get(0);
        int dp[] = new int[n];
        dp[0] = rack.get(0);
        for(int i=1;i<n;i++)
        {
            int max = 0;
            for(int j=0;j<i;j++)
            {
                if(rack.get(i)>rack.get(j) && dp[j]>max)
                    max = dp[j];
            }
            dp[i]+=max+rack.get(i);
        //    System.out.println("max "+dp[i]);
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
}