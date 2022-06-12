/*

    Time Complexity: O(N^2)
    Space Complexity: O(N)

    where 'N' is the total number of elements
    i.e the size of the input array.

*/

import java.util.*;
import java.util.Arrays;

public class Solution {
    public static int[][] pairSum(int arr[], int s) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap();
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        for(int element : arr)
        {
            int count = map.getOrDefault(s-element,0);
            ArrayList<Integer> list = new ArrayList();
            list.add(element);
            list.add(s-element);
            while(count!=0)
            {
                ans.add(new ArrayList(list));
                count--;
            }
            map.put(element,map.getOrDefault(element,0)+1);
        }
        int res[][] = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++)
        {
            int first = ans.get(i).get(0);
            int second = ans.get(i).get(1);
            res[i][0] = Math.min(first,second);
            res[i][1] = Math.max(first,second);
        }
        Arrays.sort(res,(a,b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            else
                return a[0]-b[0];
        });
        return res;
    }
}