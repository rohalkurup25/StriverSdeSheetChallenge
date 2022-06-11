import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
	     int totalSteps = m+n-2;
         int r = m-1;
        int result = 1;
        for(int i=1;i<=r;i++)
        {
            result = result*(totalSteps-r+i)/i;
        }
        return result;
	}
}