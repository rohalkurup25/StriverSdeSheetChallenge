import java.util.* ;
import java.io.*; 
/*
	Following is the structure of the Singly Linked List.	
	class LinkedListNode<T> 
    {
    	T data;
    	LinkedListNode<T> next;
    	public LinkedListNode(T data) 
        {
        	this.data = data;
    	}
	}

*/
public class Solution 
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        LinkedListNode prev = null;
        LinkedListNode curr= head;
        while(curr!=null)
        {
           LinkedListNode tempNext = curr.next;
           curr.next = prev;
           prev = curr;
           curr = tempNext;
        }
        return prev;
    }
}