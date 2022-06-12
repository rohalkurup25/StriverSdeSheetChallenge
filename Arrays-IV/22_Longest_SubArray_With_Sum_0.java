import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap();
        map.put(0,0);
        int nums[] = new int[arr.size()];
        for(int i=0;i<nums.length;i++)
        {
            if(i>0)
                nums[i] = arr.get(i)+nums[i-1];
            else
                nums[i] = arr.get(i);
        }
        for(int i=0;i<nums.length;i++)
        {
            int value = nums[i];
            if(map.containsKey(value))
               {
                   if(value==0)
                   {
                    ans = Math.max(ans,i+1);   
                   }else{
                   ans = Math.max(ans,i-map.get(value));
                   map.put(value,map.get(value));
                   }
               }
            else
               map.put(value,i);
        }
        return ans;
	}
}


// 1 4 3 7 3

// 1 0 2 0 