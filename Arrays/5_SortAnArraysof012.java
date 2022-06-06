public class Solution 
{
    public static void sort012(int[] arr)
    {
        int zeros = 0;
        int twos = arr.length-1;
        int i = 0;
        while(i<=twos)
        {
            if(arr[i]==0)
            {
                swap(arr,zeros,i);
                i++;
                zeros++;
            }
            else if(arr[i]==2)
            {
                swap(arr,twos,i);
                twos--;
            }
            else
                i++;
        }
    }
    
    
    public static void swap(int arr[],int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}