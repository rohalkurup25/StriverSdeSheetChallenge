import java.util.Stack;
import java.util.HashMap;
public class Solution {
    public static boolean isValidParenthesis(String expression) {
        HashMap<Character,Character> map = new HashMap();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack();
        for(int i=0;i<expression.length();i++)
        {
            char ch = expression.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[')
                stack.push(ch);
            else
            {
                while(true)
                {
                    if(stack.isEmpty())
                        return false;
                    else
                    {
                        char op = stack.pop();
                        if(map.get(ch)==op)
                            break;
                        else
                            return false;
                    }
                }
            }
        }
        if(stack.isEmpty())
        return true;
        return false;
    }
}