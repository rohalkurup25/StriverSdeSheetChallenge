import java.util.*;
public class Solution {
    public static List<String> findPermutations(String s) {
        List<String> ans  = new ArrayList();
        char chArray[] = s.toCharArray();
        solve(chArray,0,ans);
        return ans;
    }
    
    public static void solve(char []arr,int i,List<String> ans)
    {
        if(i==arr.length)
        {
            String s = "";
            for(char ch:arr)
            {
                s+=ch;
            }
            ans.add(s);
        }
        for(int ind=i;ind<arr.length;ind++)
        {
            swap(arr,i,ind);
            solve(arr,i+1,ans);
            swap(arr,i,ind);
        }
    }
    
    
    public static void swap(char []ch,int i,int j )
    {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}