import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static int reversePairs(ArrayList<Integer> arr) 
    {
        int count[] = new int[1];
        int n  = arr.size();
        int nums[] = new int[n];
        int i=0;
        for(int x: arr)
            nums[i++] = x;
        mergeSort(nums,0,n-1,count);
        return count[0];
    }
    
        public static  int [] mergeSort(int arr[],int start,int end,int count[])
    {
        if(start>=end)
            return new int[]{arr[start]};
        int mid = (start+(end-start)/2);
        int left[] = mergeSort(arr,start,mid,count);
        int right[] = mergeSort(arr,mid+1,end,count);
        return merge(left,right,count);
    }
    
    public static int[] merge(int []left,int []right,int count[])
    {
        int m  = left.length;
        int n = right.length;
        int ans[] = new int[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n)
        {
            if(left[i]>2*right[j])
            {
                count[0]+=m-i;
                j++;
            }
            else
                i++;
        }
        i=0;
        j=0;
        while(i<m && j<n)
        {
            if(left[i]<=right[j])
                ans[k++] = left[i++];
            else{
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