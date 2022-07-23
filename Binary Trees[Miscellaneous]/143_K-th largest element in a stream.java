import java.util.*;

public class Kthlargest {
    
    PriorityQueue<Integer> pq;
    int k;
    Kthlargest(int k, int[] arr) {
        this.k = k;
        pq = new PriorityQueue();
        for(int i=0;i<k;i++)
            add(arr[i]);
    }

    void add(int num) {
         
        if(pq.size()>=k)
        {
            int val = pq.peek();
            if(val<=num)
            {
                pq.remove();
                pq.add(num);
            }
        }
        else
            pq.add(num);
    }

    int getKthLargest() {
        return pq.peek();
    }
}