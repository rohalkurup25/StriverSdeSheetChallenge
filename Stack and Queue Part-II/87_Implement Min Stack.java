import java.util.Stack;
public class Solution {

    static class MinStack {

        Stack<Integer> stack;
        int currMin;
        MinStack() {
            stack = new Stack();
            currMin = Integer.MAX_VALUE;
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            if(stack.isEmpty())
            {
                stack.push(num);
                currMin = num;
            }
            else if(currMin>num)
            {
                int val = num*2-currMin;
                stack.push(val);
                currMin = num;
            }
            else
                stack.push(num);
        }

        // Function to remove the top element of the stack.
        int pop() {
            if(stack.isEmpty())
                return -1;
            int val = stack.pop();
            if(currMin>val)
            {
                int ans = currMin;
                currMin = 2*currMin-val; 
                return ans;
            }
            return val;
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            if(stack.isEmpty())
                return -1;
            int val =stack.peek();
            if(currMin>val)
            {
                return currMin;
            }
            return val;
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            if(stack.isEmpty())
                return -1;
            return currMin;
        }
    }
}