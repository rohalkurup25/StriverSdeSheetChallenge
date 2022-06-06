import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
    {
        int n = permutation.size();
        int i = n-2;
        while(i>=0 && permutation.get(i)>permutation.get(i+1))
            i--;
        int j = n-1;
        if(i!=-1)
        {
            while(i<j)
            {
                if(permutation.get(j)>permutation.get(i))
                    break;
                j--;
            }
            Collections.swap(permutation,i,j);
        }
        int start  = i+1;
        int end = n-1;
        while(start<end)
        {
            Collections.swap(permutation,start++,end--);
        }
        return permutation;
    }

}

// 1 9 2 9 8
// 1 9 8 9 2 