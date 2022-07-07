import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> stringMatch(String str, String pat) {
		ArrayList<Integer> ans = new ArrayList();
        int m =pat.length();
        for(int i=0;i<=str.length()-m;i++)
        {
           String s = str.substring(i,m+i);
           if(s.equals(pat))
               ans.add(i);
        }
        return ans;
	}
}