public class Solution {

public static int zAlgorithm(String s, String p, int n, int m) {
    int count=0;
    for(int i=0;i<=n-m;i++){
        String ans=s.substring(i,m+i);
        if(ans.equals(p)){
            count++;
        }
    }
    return count;
}
    
}