import java.util.ArrayList;

public class Solution
{
    public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
    {
        int low = 1;
        int high = Integer.MAX_VALUE;
        boolean even = false;
        int n = matrix.size();
        int m = matrix.get(0).size();
        if((n*m)%2==0)
            even = true;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            int count = 0;
            for(int i=0;i<n;i++)
                count+=countLessK(mid,matrix.get(i));
            if(count<=(n*m)/2)
                low = mid+1;
            else
                high = mid-1;
        }
        if(even)
            return high;
        return low;
    }
    
    public static int countLessK(int num,ArrayList<Integer> matrix)
    {
        int low = 0;
        int high = matrix.size()-1;
        while(low<=high)
        {
            int mid = (low+(high-low)/2);
            if(matrix.get(mid)<=num)
                low = mid+1;
            else
                 high = mid-1;
        }
 
        return low;
    }
}