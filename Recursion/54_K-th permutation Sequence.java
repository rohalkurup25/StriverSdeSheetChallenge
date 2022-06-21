import java.util.ArrayList;

public class Solution {
    public static String kthPermutation(int n, int k) {
        String ans = "";
        int fact = 1;
        ArrayList<Integer> list = new ArrayList();
        for(int i=1;i<n;i++){
            list.add(i);
            fact = fact*i;
        }
        list.add(n);
        k--;
        while(true)
        {
            ans+=list.get(k/fact);
            list.remove(k/fact);
            if(list.size()==0)
                return ans;
            k = k%fact;
            fact = fact/list.size();
        }
            
    }
}