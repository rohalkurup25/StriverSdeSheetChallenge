import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the LinkedListNode class:
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {

	public static boolean isPalindrome(LinkedListNode<Integer> head) {
		int count = 0;
        LinkedListNode temp = head;
        if(head==null || head.next==null)
            return true;
        while(temp!=null)
        {
            temp = temp.next;
            count++;
        }
        int mid = count/2;
        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> prev = null;
        LinkedListNode nextNode = head;
        while(mid!=0)
        {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            mid--;
        }
        if((count&1)!=0)
            curr = curr.next;

        
        while(prev!=null)
        {
            int val1 = prev.data;
            int val2 = curr.data;
            if(val1!=val2){
                return false;
            }
            
            prev = prev.next;
            curr = curr.next;
        }
        return true;
	}
}