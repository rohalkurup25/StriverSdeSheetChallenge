import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
    	Stack<Integer> stack = new Stack();
    	stack.push(-1);
    	ArrayList<Integer>  ans = new ArrayList();
    	for(int i=arr.size()-1;i>=0;i--) {
    	while(stack.peek()>=arr.get(i))
    	{
    		stack.pop();
    	}
             ans.add(stack.peek());
            stack.push(arr.get(i));
           
    	}
        Collections.reverse(ans);
		return ans;    }
} 