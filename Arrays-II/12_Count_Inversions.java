import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getInversions(long arr[], int n) {
        long count[] = new long[1];
        mergeSort(arr,0,n-1,count);
        return count[0];
    }
    
    public static  long [] mergeSort(long arr[],int start,int end,long count[])
    {
        if(start>=end)
            return new long[]{arr[start]};
        int mid = (start+(end-start)/2);
        long left[] = mergeSort(arr,start,mid,count);
        long right[] = mergeSort(arr,mid+1,end,count);
        return merge(left,right,count);
    }
    
    public static long[] merge(long []left,long []right,long count[])
    {
        int m  = left.length;
        int n = right.length;
        long ans[] = new long[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n)
        {
            if(left[i]<=right[j])
                ans[k++] = left[i++];
            else{
                count[0]+=m-i;
                ans[k++] = right[j++];
            }
        }
        while(i<m)
            ans[k++] = left[i++];
        while(j<n)
            ans[k++] = right[j++];

        return ans;
    }
}