import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
           HashSet<Integer>  set = new HashSet();
         for(int x:arr){
           if(set.contains(x))
               return x;
           else
               set.add(x);
         }
        return -1;
    }
}