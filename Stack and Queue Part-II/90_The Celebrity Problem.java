/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
import java.util.*;
public class Solution {
	public static int findCelebrity(int n) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        for(int i=1;i<n;i++)
        {
            if(Runner.knows(stack.peek(),i)){
                stack.pop();
                stack.push(i);
            }
        }
        int element = stack.peek();
        for(int i=0;i<n;i++)
        {
            if(element!=i)
            {
                if(Runner.knows(element,i) || !(Runner.knows(i,element)))
                    return -1;
            }
        }
       return element; 
    }
}