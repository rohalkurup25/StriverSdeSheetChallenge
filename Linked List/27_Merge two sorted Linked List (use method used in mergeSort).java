import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		LinkedListNode head = null;
        LinkedListNode tail = null;
        while(first!=null && second!=null)
        {
            if(first.data<second.data)
            {
                LinkedListNode node = new LinkedListNode(first.data);
                if(head==null)
                {
                    head=tail=node;
                }
                else
                {
                    tail.next = node;
                    tail = node;
                }
                first = first.next;
            }
            else
            {
                LinkedListNode node = new LinkedListNode(second.data);
                if(head==null)
                {
                    head=tail=node;
                }
                else
                {
                    tail.next = node;
                    tail = node;
                }  
                second = second.next;
            }
        }
        
        while(first!=null)
        {
                 LinkedListNode node = new LinkedListNode(first.data);
                if(head==null)
                {
                    head=tail=node;
                }
                else
                {
                    tail.next = node;
                    tail = node;
                }
                first = first.next;           
        }
        while(second!=null)
        {
               LinkedListNode node = new LinkedListNode(second.data);
                if(head==null)
                {
                    head=tail=node;
                }
                else
                {
                    tail.next = node;
                    tail = node;
                }  
                second = second.next;           
        }
        return head;
	}
}
