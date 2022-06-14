import java.util.* ;
import java.io.*; 
/************************************
	 
	 //Following is the class structure of the LinkedListNode class:
	 
	  class LinkedListNode<T> {
		public T data;
		public LinkedListNode<T> next;
		
		public LinkedListNode(T data) {
			this.data = data;
			this.next = null;
		}
	}

*****************************************/
public class Solution {

	public static int findIntersection(LinkedListNode<Integer> firstHead, LinkedListNode<Integer> secondHead) {
		int count = 0;
        LinkedListNode first = firstHead;
        LinkedListNode second = secondHead;
        while(first!=null && second!=null)
        {
            first = first.next;
            second = second.next;
        }
        LinkedListNode<Integer> start1 = null;
        LinkedListNode<Integer> start2 = null;
        if(first!=null)
        {
            start1 = firstHead;
            start2 = secondHead;
            while(first!=null){
            count++;
            first = first.next;
        }
        }
        if(second!=null)
        { 
            start1 = secondHead;
            start2 = firstHead;
            while(second!=null){
            count++;
            second = second.next;
            }
        }
        while(count!=0)
        {
            start1 = start1.next;
            count--;
        }
        while(start1!=null)
        {
            if(start1==start2){
                int valuee = start1.data;
                return valuee;
            }
            start2 = start2.next;
            start1 = start1.next;
        }
        return -1;
    }
}
