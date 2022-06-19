import java.util.*;
public class Solution
{
    public static int jobScheduling(int[][] jobs)
    {
        int n = jobs.length;
        int maxDeadline = 0;
        for(int ar[]:jobs)
                maxDeadline = Math.max(maxDeadline,ar[0]);
        int deadline[] = new int[maxDeadline+1];
        Arrays.fill(deadline,-1);
        Arrays.sort(jobs,(o1,o2)->o2[1]-o1[1]);
        int count=0;
        int profit=0;
        for(int i=0;i<n;i++)
        {
            if(ifPossible(deadline,jobs[i][0]))
            {
                count++;
                profit+=jobs[i][1];
            }
            if(count==maxDeadline)
                return profit;
        }
        return profit;
    }
    
    public static boolean ifPossible(int []arr,int i)
    {
        while(i>=1)
        {
            if(arr[i]==-1){
                arr[i] = i;
                return true;
            }
            else
                i--;
        }
        return false;
    }
}