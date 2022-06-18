import java.util.*;
public class Solution {
    
    static class TrainTime
    {
        int arrival;
        int depart;
        TrainTime(int arrival,int depart)
        {
            this.arrival = arrival;
            this.depart = depart;
        }
    }
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);
        int j = 0;
        int platform = 1;
        int ans = 1;
        int i =1;
        while(i<n && j<n)
        {
            if(at[i]<=dt[j])
            {
                platform++;
                i++;
            }
            else 
            {
                 platform--;
                 j++;
            }
            ans = Math.max(ans,platform);
        }
        return ans;
    }
}