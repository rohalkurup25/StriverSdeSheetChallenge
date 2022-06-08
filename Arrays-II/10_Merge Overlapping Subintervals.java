import java.util.* ;
import java.io.*; 
/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    
*******************************************************/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        List<Interval> ans = new ArrayList<Interval>();
        int n = intervals.length;
        if(n == 0 ) return ans;
        Arrays.sort(intervals,(a,b) -> a.start - b.start); 
        for(int i=0;i<intervals.length;i++)
        {
            int begin = intervals[i].start;
            int end = intervals[i].finish;
            if(ans.size()==0 || ans.get(ans.size()-1).finish < begin)
                ans.add(new Interval(begin,end));
            else{
                Interval i1 =new Interval(ans.get(ans.size()-1).start,
                                        Math.max(ans.get(ans.size()-1).finish,end));
                ans.set(ans.size()-1,i1);
            }
        }
        return ans;
    }
}