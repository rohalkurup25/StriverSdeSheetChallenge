import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getTrappedWater(long[] arr, int n) {
         int l = 0;
         int r = n-1;
         long totalWater = 0;
         long leftMax =0,rightMax=0;
        while(l<r)
        {
            if(arr[l]<=arr[r])
            {
                if(arr[l]>leftMax)
                    leftMax = arr[l];
                else
                    totalWater+=Math.max(0,leftMax-arr[l]);
                l++;
            }
            else
            {
                 if(arr[r]>rightMax)
                    rightMax = arr[r];
                else
                    totalWater+=Math.max(0,rightMax-arr[r]);
                r--;               
            }
        }
        return totalWater;
    }
}