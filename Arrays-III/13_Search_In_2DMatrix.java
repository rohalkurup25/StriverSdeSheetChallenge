import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	static boolean findTargetInMatrix(ArrayList<ArrayList<Integer>> mat, int m, int n, int target) {
		int start = 0;
        int end = (m*n)-1;
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            int i = mid/n;
            int j = mid%n;
            int val = mat.get(i).get(j);
            if(val==target)
                return true;
            else if(val>target)
                end = mid-1;
            else
                start=mid+1;
        }
        return false;
	}
}