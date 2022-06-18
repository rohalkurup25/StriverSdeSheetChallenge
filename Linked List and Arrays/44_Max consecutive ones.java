import java.util.ArrayList;

public class Solution {
	public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
		int j=-1;
        int zeroCount = 0;
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            int val = arr.get(i);
            if(val==0)
                zeroCount++;
            while(zeroCount>k)
            {
                j++;
                if(arr.get(j)==0)
                    zeroCount--;
            }
            int len = i-j;
            ans = Math.max(len,ans);
        }
        return ans;
	}
}