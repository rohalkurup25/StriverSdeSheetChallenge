import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

       class Node 
        { 
        public:
            int data;
            Node next;
            Node(int data) 
            {
              this.data = data;
              this.next = null;
            }
        };

*****************************************************************/

public class Solution {
    public static Node findMiddle(Node head) 
    {
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
