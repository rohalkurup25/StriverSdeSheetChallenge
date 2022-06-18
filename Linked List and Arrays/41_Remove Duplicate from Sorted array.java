import java.util.ArrayList;
public class Solution {
	public static int removeDuplicates(ArrayList<Integer> arr,int n) {
		int i = 1;
        int count = 0;
        while(i<n)
        {
            if(arr.get(i)==arr.get(i-1))
            {
                count++;
                while(i+1<n && arr.get(i)==arr.get(i+1))
                {
                    i++;
                    count++;
                }
            }
            i++;
        }
        return n-count;
	}
}
