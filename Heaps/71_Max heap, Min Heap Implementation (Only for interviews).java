import java.util.*;
public class Solution {

    static class Heap
    {
        static int []arr = new int[100000];
        static int size=-1;
        
        public static void insert(int element)
        {
            if(size==-1){
                arr[0] = element;
                size++;
            }
            else
            {
                size++;
                int i=size;
                arr[i] = element;
                while(i>0)
                {
                    int parent = (i-1)/2;
                    if(arr[parent]>arr[i])
                    {
                        swap(arr,i,parent);
                        i = parent;
                    }
                    else
                        break;
                }
            }
        }
        
        public static int remove()
        {
            if(size==-1)
                return -1;
            int i=0;
            int ans = arr[0];
            arr[i] = arr[size];
            size--;
            while(i<size)
            {
                int min=i;
                int left = 2*i+1;
                int right = 2*i+2;
                if(left<=size && arr[min]>arr[left])
                    min = left;
                if(right<=size && arr[min]>arr[right])
                    min = right;
                if(min==i)
                    break;
                swap(arr,min,i);
                i = min; 
            }
            return ans;
        }
        
        public static void swap(int []arr,int i,int j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] =temp;
        }
    }
    // minHeap function which take size of Queries and Queries as Input.
// Returns an array out outputs depending on the query.
    static int[] minHeap(int n, int[][] q) {
        ArrayList<Integer> ans = new ArrayList();
        for(int arr[] : q)
        {
            if(arr[0]==0)
                Heap.insert(arr[1]);
            else
                ans.add(Heap.remove());
        }
        Heap.size=-1;
        int ansArray[] = new int[ans.size()];
        int i=0;
        for(int x:ans)
            ansArray[i++] = x;
        return ansArray;
    }
}