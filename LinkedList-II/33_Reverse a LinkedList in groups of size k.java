import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
	        int data;
	        Node *next;
	        Node(int data)
	        {
		        this->data = data;
		        this->next = NULL;
	        }
        };

*****************************************************************/

public class Solution {
	public static Node getListAfterReverseOperation(Node head, int n, int b[])       {	
        return solve(head,0,b);
	}
    
    public static Node solve(Node head,int i,int b[])
    {
        if(head==null)
            return null;
        if(i==b.length)
            return head;
        if(b[i]==0)
            return solve(head,i+1,b);
        int val = b[i];
        Node curr = head;
        Node prev = null;
        Node nextNode = curr.next;;
        while(curr!=null && val!=0)
        {
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                val--;
        }
        
        head.next = solve(nextNode,i+1,b);
        return prev; 
    }
}