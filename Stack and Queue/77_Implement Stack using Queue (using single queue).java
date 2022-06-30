import java.util.*;

public class Stack {

    // Define the data members.
    Queue<Integer> queue;

    public Stack() {
        queue = new LinkedList(); 
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void push(int element) {
        queue.add(element);
    }

    public int pop() {
        int element = -1;
        if(isEmpty())
            return element;
        else
        {
            int size  = queue.size();
            while(size!=1)
            {
                int val = queue.remove();
                size--;
                queue.add(val);
            }
            element  = queue.remove();
        }
        return element;
    }

    public int top() {
        int element = -1;
        if(isEmpty())
            return element;
        else
        {
            int size  = queue.size();
            while(size!=1)
            {
                int val = queue.remove();
                size--;
                queue.add(val);
            }
            element  = queue.remove();
            queue.add(element);
        }
        return element;   
    }
}