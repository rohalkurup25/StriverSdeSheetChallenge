import java.util.* ;
import java.io.*; 
/***********************************************
    Following is the class structure of the Node class:

    class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

************************************************/

public class Solution {
    public static Node rotate(Node head, int k) {
        int n = 0;
        Node temp = head;
        while(temp!=null)
        {
            n++;
            temp = temp.next;
        }
        k = k%n;
        if(k==0 || head==null || head.next==null)
            return head;
        Node slow = head;
        Node fast = head;
        while(k!=0)
        {
            fast = fast.next;
            k--;
        }
        while(fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        Node newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}