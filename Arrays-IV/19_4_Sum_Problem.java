import java.util.* ;
import java.io.*; 
public class Solution {
  public static String fourSum(int[] arr, int target, int n) {
      Arrays.sort(arr);
      for(int i=0;i<n;i++)
      {
          for(int j=i+1;j<n;j++)
          {
              int low = j+1;
              int high = n-1;
              int sum = target-(arr[i]+arr[j]);
              while(low<high)
              {
                  int calcualatedSum = arr[low]+arr[high];
                  if(calcualatedSum==sum)
                      return "Yes";
                  else if(calcualatedSum>sum)
                      high--;
                  else
                      low++;
              }
          }
      }
      return "No";
  }
}
