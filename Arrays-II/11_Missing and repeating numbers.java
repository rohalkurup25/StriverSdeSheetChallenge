import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int xor1 = arr.get(0);
        for(int i=1;i<n;i++)
            xor1 = xor1^arr.get(i);
        for(int i=1;i<=n;i++)
            xor1 = xor1^i;
        int rsb = xor1 & -xor1;
        int x=0,y=0;
        for(int i=0;i<n;i++)
        {
            if((rsb & arr.get(i))!=0)
                x = x^arr.get(i);
            else
                y = y^arr.get(i);
        }
        for(int i=1;i<=n;i++)
        {
            if((rsb & i)!=0)
                x = x^i;
            else
                y = y^i;
        }   
        boolean flag = false;
        for(int i=0;i<n;i++)
        {
            if(arr.get(i)==x)
                flag = true;
        }
        if(flag)
            return new int[]{y,x};
        else
            return new int[]{x,y};
    }
}