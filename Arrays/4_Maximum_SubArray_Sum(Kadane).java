import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
		// write your code here
        
        long max = arr[0];
        long curr = arr[0];
        max = Math.max(0,max);
        for(int i=1;i<arr.length;i++)
        {
            if(curr<0)
               curr = 0;
            curr+=arr[i];
            max = Math.max(curr,max);

        }
        return max;
	}

}