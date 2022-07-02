import java.util.Stack;
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
        if(stack.isEmpty())
            return;
		int pop = stack.pop();
        sortStack(stack);
        sort(stack,pop);
	}
    
    public static void sort(Stack<Integer> stack,int pop)
    {
         if(stack.isEmpty() || stack.peek()<=pop){
             stack.push(pop);
             return;   
         }
         int peek  = stack.pop();
         sort(stack,pop);
         stack.push(peek);
    }
    
}