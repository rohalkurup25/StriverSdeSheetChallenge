import java.util.* ;
import java.io.*; 
/****************************************************************

       Following is the class structure of the Node class:

       class Node {
	int data;
	Node next;
	Node child;

	public Node(int data) {
		this.data = data;
		this.next = null;
		this.child = null;
	}
}

*****************************************************************/
public class Solution {
	public static Node flattenLinkedList(Node start) {
		if(start==null)
            return start;
        if(start.next==null)
            return start;
        Node lastNode = flattenLinkedList(start.next);
        Node merge = merge(lastNode,start);
        lastNode.next = null;
        start.next = null;
        return merge;
	}
    
    public static Node merge(Node first,Node second)
    {
        Node head = null;
        Node tail = null;
        while(first!=null && second!=null)
        {
            if(first.data>second.data)
            {
                if(head==null)
                    head = tail = second;
                else
                {
                    tail.child = second;
                    tail = second;
                }
                second = second.child; 
            }
            else
            {
                if(head==null)
                    head = tail = first;
                else
                {
                    tail.child = first;
                    tail = first;
                }
                first = first.child;
            }
        }
        while(first!=null)
        {
                 if(head==null)
                    head = tail = first;
                else
                {
                    tail.child = first;
                    tail = first;
                }    
                    first = first.child;
        }
        while(second!=null)
        {
                if(head==null)
                    head = tail = second;
                else
                {
                    tail.child = second;
                    tail = second;
                }   
                second = second.child;
        }
        return head;
    }
}
