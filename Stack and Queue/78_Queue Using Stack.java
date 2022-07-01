import java.util.*;
public class Queue {
    // Define the data members(if any) here.
    Stack<Integer> s1;
    Stack<Integer> s2;
    Queue() {
        s1 = new Stack();
        s2 = new Stack();
    }

    void enQueue(int val) {
        s1.push(val);
    }

    int deQueue() {
        if(s1.empty()){
            return -1;
        }
        while(!s1.empty()){
            s2.push(s1.peek());
            s1.pop();
        }
        int ans=s2.peek();
        s2.pop();
        while(!s2.empty()){
            s1.push(s2.peek());
            s2.pop();
        }
        return ans;
    }

    int peek() {
         if(s1.empty()){
            return -1;
        }
        while(!s1.empty()){
            s2.push(s1.peek());
            s1.pop();
        }
        int ans=s2.peek();

        while(!s2.empty()){
            s1.push(s2.peek());
            s2.pop();
        }
        return ans;       // Implement the peek() function here.
    }

    boolean isEmpty() {
        return s1.empty();
    }
}