public class Solution {
    public static int search(int arr[], int key) {
        int n = arr.length;
        int pivot = findPivot(arr);
   //   System.out.println("pivot "+pivot);
        int ans=-1;
        if(pivot==n)
           ans =  binarySearch(arr,key,0,n-1);
        else
        {
            ans = binarySearch(arr,key,0,pivot-1);
            if(ans==-1)
                ans = binarySearch(arr,key,pivot,n-1);
        }
        return ans;
    }
    
    public static int findPivot(int arr[])
    {
        int low = 0;
        int high = arr.length-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid]>=arr[0])
                low = mid+1;
            else
                high = mid-1;
        }
        return low;
    }
    
    public static int binarySearch(int arr[],int key,int low,int high)
    {
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid]==key)
                return mid;
            else if(arr[mid]>key)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
    
    
}


//Better approach 

public class Solution {
    public static int search(int arr[], int key) {
        int low = 0;
        int high = arr.length-1;
        while(low<=high)
        {
            int mid = (low+high)>>1;
            if(arr[mid]==key)
                return mid;
            else if(arr[mid]>=arr[low])
            {
                if(key>=arr[low] && key<=arr[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
            else
            {
                if(key>=arr[mid] && key<=arr[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
}
