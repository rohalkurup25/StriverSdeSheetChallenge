import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> ans = new ArrayList();
        ArrayList<Long> prev = new ArrayList();
        prev.add(1l);
        ans.add(new ArrayList(prev));
        for(int i=1;i<n;i++)
        {
            Long curr[] = new Long[i+1];
            for(int j=0;j<=(i/2);j++)
            {
                Long val = 0l;
                if(j==0)
                    val = prev.get(j);
                else
                    val = prev.get(j-1)+prev.get(j);
                curr[j] = val;
                curr[i-j]=val;
            }
            ArrayList<Long> temp = new ArrayList();
            Collections.addAll(temp,curr);
            ans.add(temp);
            prev = new ArrayList(temp);        
        }
        return ans;
    }
}