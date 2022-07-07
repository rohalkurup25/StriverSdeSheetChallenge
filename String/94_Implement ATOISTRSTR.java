public class Solution {
    public static int atoi(String str) {
        boolean minus = false;
        String ans = "";
        if(str.charAt(0)=='-')
            minus=true;
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
             if(ch-'0'>=0 && ch-'0'<=9)
                ans+=ch;
        }
        if(ans.length()==0)
            return 0;
        int ansu = Integer.parseInt(ans);
        if(minus)
        return ansu*-1;
        return ansu;
    }
}