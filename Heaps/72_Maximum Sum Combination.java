import java.util.*;

public class Solution{
    
    static class Node
    {
        int i;
        int j;
        int sum;
        
        Node(int i,int j, int sum)
        {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
    
    
	public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k){
        ArrayList<Integer> ans = new ArrayList();
		Collections.sort(a, Collections.reverseOrder());
        Collections.sort(b, Collections.reverseOrder());
        PriorityQueue<Node> pq = new PriorityQueue<Node>((node1,node2)->node2.sum-node1.sum);
        HashSet<String> set = new HashSet();
        pq.add(new Node(0,0,a.get(0)+b.get(0)));
        set.add(0+"-"+0);
        int n1= a.size();
        int m1 = b.size();
        while(!pq.isEmpty() && k>=1 )
        {
            Node node = pq.remove();
            ans.add(node.sum);
            k--;
            if((node.i+1)<n1 && !set.contains((node.i+1)+"-"+node.j)){
                pq.add(new Node(node.i+1,node.j,a.get(node.i+1)+b.get(node.j)));
                set.add((node.i+1)+"-"+node.j);
            }
            if((node.j+1)<m1 && !set.contains(node.i+"-"+(node.j+1))){
                pq.add(new Node(node.i,node.j+1,a.get(node.i)+b.get(node.j+1)));
                set.add(node.i+"-"+(node.j+1));
            }
        }
        return ans;
	}
}