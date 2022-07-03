import java.util.ArrayList;
import java.util.Stack;
public class Solution {
  public static int largestRectangle(ArrayList < Integer > heights) {
    int n = heights.size();
    int arr[] = new int[n];
    int i=0;
    for(int x:heights)
        arr[i++]=x;
        int a1[] = new int[n];
        int b1[] = new int[n];
        a1 = getSmallest(arr);
        b1 = getSmallest2(arr);
        int area = Integer.MIN_VALUE;

        for( i=0;i<n;i++)
        {
            int l = arr[i];
            if(a1[i]==-1)
                a1[i]=n;
            int b = a1[i]-b1[i]-1;
            int newArea = l*b;
            area = Math.max(area,newArea);
        }
     return area;  
    
  }
    
  public static int[] getSmallest(int []arr)
    {
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        int ans[] = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--)
        {
            int curr = arr[i];
            while(stack.peek()!=-1 && curr<=arr[stack.peek()])
            {
                stack.pop();
            }
            ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
        
    public static int[] getSmallest2(int []arr)
    {
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        int ans[] = new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            int curr = arr[i];
            while(stack.peek()!=-1 && curr<=arr[stack.peek()])
            {
                stack.pop();
            }
            ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
}