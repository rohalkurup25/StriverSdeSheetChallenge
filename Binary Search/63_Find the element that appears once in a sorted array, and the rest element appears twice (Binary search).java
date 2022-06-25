import java.util.ArrayList;

public class Solution 
{
    public static int uniqueElement(ArrayList<Integer> arr) 
    {
        int luckyNumber = 0;
        for(int x: arr)
            luckyNumber^=x;
        return luckyNumber;
    }
    
    //Binary Search
    
}



import java.util.ArrayList;

public class Solution 
{
    public static int uniqueElement(ArrayList<Integer> arr) 
    {
        int low = 0;
        int high = arr.size()-2;
        while(low<=high)
        {

            int mid = (low+high)>>1;
                if(arr.get(mid).equals(arr.get(mid^1)))
                    low = mid+1;
                else
                    high = mid-1;
 
        }
        return arr.get(low);
    }
}
