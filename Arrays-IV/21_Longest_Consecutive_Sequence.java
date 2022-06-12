import java.util.* ;
import java.io.*; 
public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        int longestConsSeq = 0;
        HashSet<Integer> set  = new HashSet();
        for(int element :arr)
        set.add(element);
        
        for(int element:arr)
        {
            if(!set.contains(element-1))
            {
                int value = element;
                int count =1;
                while(set.contains(value+1))
                {
                    count++;
                    value++;
                }
                longestConsSeq  = Math.max(longestConsSeq,count);
            }
        }
        return longestConsSeq;
    }
}