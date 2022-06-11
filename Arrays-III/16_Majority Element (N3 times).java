import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
         int val1=-1,val2=-1;
         int cnt1=0,cnt2=0;
        for(int x:arr)
        {
            if(val1==x)
                cnt1++;
            else if(val2==x)
                cnt2++;
            else if(cnt1==0)
            {
                val1 = x;
                cnt1++;
            }
            else if(cnt2==0)
            {
                val2 = x;
                cnt2++;
            }
            else
            {
                cnt1--;
                cnt2--;
            }
        }
        
        int val1Cnt=0;
        int val2Cnt=0;
        for(int x:arr)
        {
            if(x==val1)
                val1Cnt++;
            if(x==val2)
                val2Cnt++;
        }
        ArrayList<Integer> ans = new ArrayList();
        int n = arr.size();
        if(val1Cnt>n/3)
            ans.add(val1);
        if(val2Cnt>n/3)
            ans.add(val2);
        return ans;
    }
}
