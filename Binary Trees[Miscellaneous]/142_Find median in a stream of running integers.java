import java.util.*;

public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        int ans[] = new int[n];
        if(n==0)
            return ans;
        PriorityQueue<Integer> min = new PriorityQueue();
        PriorityQueue<Integer> max = new                     PriorityQueue(Collections.reverseOrder());
        min.add(arr[0]);
        ans[0] = arr[0];
        for(int i=1;i<n;i++)
        {
            int n1 = min.size();
            int n2 = max.size();
            if(n1==n2 || n1>n2)
            {
                if(arr[i]>min.peek())
                {
                    int popped = min.remove();
                    min.add(arr[i]);
                    max.add(popped);
                }
                else
                    max.add(arr[i]);
                }
            else
               {
                   if(max.peek()>arr[i])
                   {
                       int popped = max.remove();
                       min.add(popped);
                       max.add(arr[i]);
                   }
                   else
                       min.add(arr[i]);
               }
            n1 = min.size();
            n2 = max.size();
            if(n1==n2)
                ans[i] = (min.peek()+max.peek())/2;
            else if(n1>n2)
                ans[i] = min.peek();
            else
                ans[i] = max.peek();
        }
        return ans;
    }
}