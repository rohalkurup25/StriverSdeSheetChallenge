import java.util.Stack;
public class Solution {
	
	public static int[] nextGreater(int[] arr, int n) {	
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack();
        ans[n-1] = -1;
        stack.push(arr[n-1]);
        for(int i=n-2;i>=0;i--)
        {
            int element = arr[i];
            while(!stack.isEmpty() && stack.peek()<=element)
                stack.pop();
            if(stack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();
            stack.push(element);
        }
        return ans;
	}

}