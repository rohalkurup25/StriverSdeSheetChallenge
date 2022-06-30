
public class Stack {
    int arr[];
    int index;
    int size;
    
    Stack(int capacity)
    {
        this.arr = new int[capacity];
        index=-1;
        this.size = capacity;
    }
    void push(int num) {
        if(index!=size-1)
        {
            index++;
            arr[index]=num;
        }
    }
    int pop() {
        int ans = -1;
        if(index==-1)
            return ans;
        else
        {
            ans = arr[index];
            index--;
        }
        return ans;
    }
    int top() {
        if(index==-1)
            return -1;
        else
           return arr[index];
    }
    int isEmpty() {
        if(index==-1)
            return 1;
        else
            return 0;
    }
    int isFull() {
        if(index==size-1)
            return 1;
        else
            return 0;
    }
}