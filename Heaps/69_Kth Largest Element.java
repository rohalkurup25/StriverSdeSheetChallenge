import java.util.*;


public class Solution {
	public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
		Collections.sort(arr);
         ArrayList<Integer> ans = new ArrayList();
        ans.add(arr.get(k-1));
        ans.add(arr.get(n-k));
        return ans;
	}
}