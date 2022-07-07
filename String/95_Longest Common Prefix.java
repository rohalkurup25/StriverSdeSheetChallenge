import java.util.*;
public class Solution {
    public static String longestCommonPrefix(String[] arr, int n) {
        if(n==1)
            return arr[0];
        Arrays.sort(arr);
        String first = arr[0];
        String last = arr[n-1];
        int i=0;
        int j=0;
        while(i<first.length() && j<last.length())
        {
            if(first.charAt(i)!=last.charAt(j))
                break;
            i++;
            j++;
        }
        if(i==0)
            return "";
        else
            return first.substring(0,i);
    }

}