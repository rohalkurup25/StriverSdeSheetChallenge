import java.util.* ;
import java.io.*; 
/****************************************************************
	
	Following is the structure of the Singly Linked List.
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

****************************************************************/

public class Solution {
	public static LinkedListNode<Integer> removeKthNode(LinkedListNode<Integer> head, int K) {
        if(head==null || K==0)
            return head;
		LinkedListNode fast = head;
        while(K!=0)
        {
            fast = fast.next;
            K--;
        }
        LinkedListNode slow = head;
        if(fast==null)
            head = head.next;
        else
        {
            while(fast.next!=null)
            {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
        }
        return head;
        }
}