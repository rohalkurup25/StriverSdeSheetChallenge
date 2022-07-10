import java.util.Arrays;
public class Solution {
    public static boolean areAnagram(String str1, String str2){
        int n=str1.length();
        int m =str2.length();
        char st1[] = str1.toCharArray();
        char st2[] = str2.toCharArray();
        Arrays.sort(st1);
        Arrays.sort(st2);
        if(n!=m)
            return false;
        for(int i=0;i<n;i++)
        {
            char ch1 = st1[i];
            char ch2 = st2[i];
            if(ch1!=ch2)
                return false;
        }
        return true;
    }
}