import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the LinkedListNode class structure

    class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }

*************************************************************/

public class Solution {
	public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
	    LinkedListNode cloneHead  = null;
        LinkedListNode tail = null;
        LinkedListNode temp = head;
        while(temp!=null)
        {
            LinkedListNode node = new LinkedListNode(temp.data);
            if(cloneHead==null)
                cloneHead = tail =  node;
            else
            {
                tail.next = node;
                tail = node;
            }
            temp = temp.next;
        }
        LinkedListNode temp1 = head;
        LinkedListNode temp2 = cloneHead;
        HashMap<LinkedListNode,LinkedListNode> map = new HashMap();
        while(temp1!=null && temp2!=null)
        {
            map.put(temp1,temp2);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        temp1 = head;
        temp2 = cloneHead;
        while(temp1!=null)
        {
            LinkedListNode randomNode = map.get(temp1.random);
            if(randomNode!=null)
                temp2.random = randomNode;
            temp1=temp1.next;
            temp2 = temp2.next;
        }
        return cloneHead;
	}
}