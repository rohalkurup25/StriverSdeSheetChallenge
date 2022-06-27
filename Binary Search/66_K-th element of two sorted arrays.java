public class Solution {
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
        if(m>n)
            return ninjaAndLadoos(row2,row1,n,m,k);
        int low = 0;

        int high = m;

        while(low<=high)
        {
            int mid = (low+high)>>1;
            int cut1 = mid;
            int cut2 = k-cut1;
   //         System.out.println(cut1+" "+cut2);
            if(cut1>k)
            {
                high = mid-1;
                continue;
            }
            if(cut2>n)
            {
                low = mid+1;
                continue;
            }
            
            int left1 = cut1<=0?Integer.MIN_VALUE:row1[cut1-1];
            int left2 = cut2<=0?Integer.MIN_VALUE:row2[cut2-1];
            
            int right1 = cut1>=m?Integer.MAX_VALUE:row1[cut1];
            int right2 = cut2>=n?Integer.MAX_VALUE:row2[cut2];
            
            if(left1<=right2 && left2<=right1)
            {
                return Math.max(left1,left2);
            }
            else if(left1>right2)
                high = cut1-1;
            else
                low = cut1+1;
            
        }
        return -1;
    }
}



// 3   3 8 17 
// 4 12    8 13 20