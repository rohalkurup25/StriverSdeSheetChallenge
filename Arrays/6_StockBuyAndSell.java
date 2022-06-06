import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int price:prices)
        {
            min = Math.min(min,price);
            ans = Math.max(ans,price-min);
        }
        return ans;
    }
}