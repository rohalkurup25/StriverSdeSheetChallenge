
import java.util.ArrayList;
import java.util.PriorityQueue;
public class Solution 
{

	public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k) 
	{
        ArrayList<Integer> ans = new ArrayList();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->nums.get(b)-nums.get(a));
        int n = nums.size();
        for(int i=0;i<k && i<n;i++)
            pq.add(i);
        ans.add(nums.get(pq.peek()));
                int j=0;
        for(int i=k;i<n;i++)
                {
                    pq.remove(j++);
                    pq.add(i);
                    ans.add(nums.get(pq.peek()));
                }
        return ans;
	}
}