public class Solution {

   public static long ayushGivesNinjatest(int n, int m, int[] time) {

      long s = 0;

       long sum = 0;

       for(int i=0;i<m;i++){

           sum = sum + time[i];

       }

       long e = sum;

       long ans = -1;

       long mid = s +(e-s)/2;

       while(s<=e){

           if(isPossible(time,n,mid,m)){

               ans = mid;

               e = mid-1;

           }else{

               s = mid +1;

           }

            mid = s +(e-s)/2;

       }

       return ans;

   }

 private  static boolean isPossible(int[] time,int n,long mid,int m){

      long TotalDays = 1;

      long Chapters =0;

      for(int i=0;i<m;i++){

          if(Chapters + time[i] <= mid){

              Chapters = Chapters + time[i];

          }else{

              TotalDays++;

              if(TotalDays>n || time[i]>mid){

                  return false;

              }

              Chapters = time[i];

          }

      }

      return true;

  }

}