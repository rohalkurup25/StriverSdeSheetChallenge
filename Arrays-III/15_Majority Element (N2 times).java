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

// Moore's Algorithm 
 
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int findMajority(int[] arr, int n) {
        int val = arr[0];
        int count =1;
        for(int i=1;i<n;i++)
        {
            if(val==arr[i])
                count++;
            else
            {
                if(count==1)
                {
                    val = arr[i];
                }
                else
                    count--;
            }
        }
        int canCount = 0;
        for(int x:arr)
        {
            if(x==val)
                canCount++;
        }
        if(canCount>n/2)
            return val;
        else
            return -1;
	}
}
