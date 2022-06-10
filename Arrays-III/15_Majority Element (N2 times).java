import java.util.* ;
import java.io.*; 
public class Solution {
	public static int findMajority(int[] arr, int n) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int x:arr)
            map.put(x,map.getOrDefault(x,0)+1);
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            if(entry.getValue()>n/2)
                return entry.getKey();
        }
        return -1;
	}
}