public class Queue {
    class Node
    {
        int data;
        Node next;
        
        Node(int data)
        {
            this.data = data;
        }
    }
    
    Node head ;
    Node tail;
    Queue() {
       head = null;
       tail = null;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        if(head==null)
            return true;
        return false;
    }

    void enqueue(int data) {
        Node node = new Node(data);
        if(head==null)
        {
            head = tail = node;
        }
        else
        {
            tail.next = node;
            tail = node;
        }
        
    }

    int dequeue() {
        int ans = -1;
        if(head==null)
            return -1;
        else
        {
            ans = head.data;
            head = head.next;
        }
        return ans;
    }

    int front() {
        if(head==null)
            return -1;
        return head.data;
    }

}