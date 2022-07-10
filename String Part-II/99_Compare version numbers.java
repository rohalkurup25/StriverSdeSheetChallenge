import java.math.BigInteger;

public class Solution 
{
public static int compareVersions(String a, String b) 
    {
        if(a.length() == 0 ) return -1;
        if(b.length() == 0 ) return 1;
        String[] first = a.split("\\.");
        String[] second = b.split("\\.");
        int n1 = first.length, n2 = second.length;

     BigInteger i1, i2;
     for (int i = 0; i < Math.max(n1, n2); ++i) {
      i1 = i < n1 ?  new BigInteger(first[i]) :           BigInteger.ZERO;
      i2 = i < n2 ? new BigInteger(second[i]) : BigInteger.ZERO;
      if (i1.compareTo(i2) ==1) {
        return 1 ;
      }
       if (i1.compareTo(i2) ==-1) {
        return -1 ;
      }
    }
    
    return 0;
    }
}