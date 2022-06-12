import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
	    int n = arr.size();
        int ans = 0;
        HashMap<Integer,Integer> prefixMap = new HashMap();
        prefixMap.put(0,1);
        int prefTotal = 0;
        for(int element : arr)
        {
            prefTotal^=element;
            if(prefixMap.containsKey(prefTotal^x)){
                ans+=prefixMap.get(prefTotal^x);
            }
            if(prefixMap.get(prefTotal)!=null)
                prefixMap.put(prefTotal,prefixMap.get(prefTotal)+1);
            else
                prefixMap.put(prefTotal,1);
        }
        return ans;
	}
}


