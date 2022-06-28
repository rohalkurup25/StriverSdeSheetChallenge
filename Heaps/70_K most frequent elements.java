import java.util.*;
public class Solution {
    static class Node
    {
        int val;
        int freq;
        Node(int val,int freq)
        {
            this.val = val;
            this.freq = freq;
        }
    }
	public static int[] KMostFrequent(int n, int k, int[] arr) {
                HashMap<Integer,Integer> map = new HashMap();
        for(int x:arr)
        {
            map.put(x,map.getOrDefault(x,0)+1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1,o2)->o2.freq-o1.freq);
        for(int key : map.keySet())
        {
            pq.add(new Node(key,map.get(key)));
        }
        int ans[] = new int[k];
        for(int i=0;i<k;i++)
            ans[i] = pq.remove().val;
        return ans;
    }

}