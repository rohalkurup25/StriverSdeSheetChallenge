import java.util.*;

public class Solution {

	public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<k;i++)
            map.put(arr.get(i),map.getOrDefault(arr.get(i),0)+1);
        ArrayList<Integer> ans = new ArrayList();
        ans.add(map.size());
        for(int i=k;i<arr.size();i++)
        {
            int val = arr.get(i-k);
            int freq = map.get(val);
            if(freq==1)
                map.remove(val);
            else
                map.put(val,freq-1);
            map.put(arr.get(i),map.getOrDefault(arr.get(i),0)+1);
            ans.add(map.size());
        }
        return ans;
	}
}