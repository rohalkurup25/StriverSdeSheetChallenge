public class Solution 
{
    public static String reverseString(String str) 
    {
        str = str.trim();
        StringBuilder answer = new StringBuilder("");
        String ans[] = str.split(" ");
        for(int i=ans.length-1;i>=0;i--)
            {
                String s = ans[i];
                s = s.trim();
                if(s.length()==0)
                    continue;
                answer.append(s);
                if(i!=0)
                    answer.append(" ");
            }
        return answer.toString();
    }
}