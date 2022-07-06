
import java.util.*; 
    public class Solution {
    public static int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans = map.get(s.charAt(s.length()-1));
        for(int i=s.length()-2;i>=0;i--)
        {
           char ch  = s.charAt(i);
           int val = map.get(ch);
           int val2 = map.get(s.charAt(i+1));
           if(val<val2){
               ans=  ans-map.get(ch);
           }
            else{
               ans= map.get(ch)+ans;
            }
            
        }
        return ans;
    }
}