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
}