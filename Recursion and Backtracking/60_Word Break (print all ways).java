import java.util.*;

public class Solution {

	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		HashSet<String> set  = new HashSet();
        for(String so  : dictionary)
            set.add(so);
        ArrayList<String> ans = new ArrayList();
        solve(s,set,"",ans);
        return ans;
	}
    
    public static void solve(String s,HashSet<String> set,String ansString,ArrayList<String> ans)
    {
        if(s.length()==0)
        {
            ans.add(ansString.substring(0,ansString.length()-1));
            return;
        }
        for(int i=0;i<s.length();i++)
        {
            String leftString =  s.substring(0,i+1);
            if(set.contains(leftString))
            {
                String rightString="";
                if(i+1<s.length())
                    rightString = s.substring(i+1);
                solve(rightString,set,ansString+leftString+" ",ans);
            }
        }
    }
}