import java.util.* ;
import java.io.*; 
public class Solution {

    public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans  = new ArrayList();
        for(int i=0;i<arr.length;i++)
        {
            int low = i+1;
            int high = arr.length-1;
            int target = K-arr[i];
            if(i>0 && arr[i]==arr[i-1])
                continue;
            while(low<high)
            {
                int val = arr[low]+arr[high];
                if(val==target)
                {
                    ArrayList<Integer> list = new ArrayList();
                    list.add(arr[i]);
                    list.add(arr[low]);
                    list.add(arr[high]);
                    ans.add(new ArrayList(list));
                    while(low<high && arr[low]==arr[low+1])
                        low++;
                    while(low<high && arr[high]==arr[high-1])
                        high--;
                    low++;
                    high--;   
                }
                else if(val>target)
                    high--;
                else
                    low++;
            }

        }
        return ans;
    }
}
