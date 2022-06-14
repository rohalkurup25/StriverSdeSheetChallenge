import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

    class LinkedListNode {
        int data;
        LinkedListNode next;
        
        public LinkedListNode(int data) {
            this.data = data;
        }
    }

*****************************************************************/


public class Solution {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode head = null;
        int carry=0;
        LinkedListNode tail = null;
        while(head1!=null && head2!=null)
        {
            int val = carry+head1.data+head2.data;
            carry = val/10;
            val = val%10;
            LinkedListNode node = new LinkedListNode(val);
            if(head==null)
                head=tail=node;
            else
            {
                tail.next = node;
                tail = node;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        while(head1!=null)
        {
            int val = head1.data+carry;
            carry = val/10;
            val = val%10;
            LinkedListNode node = new LinkedListNode(val);
            tail.next = node;
            tail = node;
            head1 = head1.next;
        }
        while(head2!=null)
        {
            int val = head2.data+carry;
            carry = val/10;
            val = val%10;
            LinkedListNode node = new LinkedListNode(val);
            tail.next = node;
            tail = node;
            head2 = head2.next;            
        }
        if(carry!=0)
        {
            tail.next = new LinkedListNode(carry);
            tail = tail.next;
        }
        return head;
    }
}