import java.util.*;

public class Solution {

	static int kthLargest(ArrayList<Integer> arr, int size, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i=0;i<K;i++)
            pq.add(arr.get(i));
        for(int i=K;i<size;i++)
        {
            if(pq.peek()<arr.get(i))
            {
                pq.remove();
                pq.add(arr.get(i));
            }
        }

        return pq.peek();
	}
}