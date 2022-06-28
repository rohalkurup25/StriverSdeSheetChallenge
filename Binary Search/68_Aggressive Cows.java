import java.util.*;
public class Solution {

    public static int chessTournament(int[] positions, int n,  int c) 
	{
        long high = 0;
        long ans = 0;
        Arrays.sort(positions);
       for(int x:positions)
           high+=x;
        long low = 0;
        while(low<=high)
        {
            long mid = low+(high-low)/2;
            boolean res =isPossible(positions,n,c,mid);
            if(res){
                ans = mid;
                low = mid+1;
            }
            else
                high = mid-1;;
        }
        return (int)ans;
    }

    
    public static boolean isPossible(int []pos,int n,int c,long target)
    {
        int first = pos[0];
        int count=1;
        for(int i=1;i<n;i++)
        {
            if(Math.abs(first-pos[i])>=target)
            {
                count++;
                first = pos[i];

            }   
        }
        if(count<c)
            return false;
        return true;
    }
} 