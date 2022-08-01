import java.util.*;

public class Solution {
    public static Boolean wordBreak(String[] arr, int n, String target) {
        
        HashMap<String,Boolean> map = new HashMap();
        return solve(arr,n,target,map);
    }
    
    public static boolean solve(String []arr,int n,String target,HashMap<String,Boolean> map)
    {
        if(target.length()==0)
            return true;
        int size = target.length();
        if(map.containsKey(target))
            return map.get(target);
        for(int i=1;i<=size;i++)
        {
            String tar  = target.substring(0,i);
            boolean flag = false;
            for(String str : arr)
            {
                if(tar.equals(str))
                {
                    flag = true;
                    break;
                }
            }
            String subStr = "";
            subStr = target.substring(i,size);
            if(flag && solve(arr,n,subStr,map))
            {
                map.put(target,true);
                return true;
            }
        }
        map.put(target,false);
        return false;
    }
}