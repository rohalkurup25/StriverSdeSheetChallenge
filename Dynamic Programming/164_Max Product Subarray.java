import java.util.ArrayList;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {

        int ans = Integer.MIN_VALUE;
        int currMin = 1;
        int currMax = 1;
        for(int i=0;i<arr.size();i++)
        {
            int val = arr.get(i);
            int temp = currMax*val;
            currMax = Math.max(currMax*val,Math.max(currMin*val,val));
            currMin  = Math.min(temp,Math.min(currMin*val,val));
            ans = Math.max(ans,currMax);
        }
        
        return ans;
	}
   
    
    
}