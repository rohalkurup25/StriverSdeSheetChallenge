import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static int uniqueSubstrings(String input) 
    {
        char chArray[] = input.toCharArray();
        int start = 0;
        HashMap<Character,Integer> map = new HashMap();
        int ans = 0;
        for(int i=0;i<chArray.length;i++)
        {
            char ch  = chArray[i];
            if(!map.containsKey(ch))
            {
                ans = Math.max(i-start+1,ans);
                map.put(ch,i);
            }
            else
            {
                int newStart = Math.max(start, map.get(ch)+1);
                for(int k = start;k<newStart;k++)
                    map.remove(chArray[k]);
                start  = newStart;
                map.put(ch,i);
            }
                
        }
        return ans;
    }
}