import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        ArrayList<Integer> ans = new ArrayList();
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        for(int i=0;i<price.size();i++)
        {
            int rupya = price.get(i);
            while(stack.peek()!=-1 && price.get(stack.peek())<=rupya)
                stack.pop();
            ans.add(i-stack.peek());
            stack.add(i);
        }
        return ans;
    }
}