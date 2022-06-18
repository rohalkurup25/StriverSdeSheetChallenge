import java.util.*;;
public class Solution {
     
    static class Triple
    {
        int start;
        int end;
        int pos;
        
        Triple(int start,int end,int pos)
        {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }
    
    
    public static List<Integer> maximumMeetings(int[] start, int[] end) {               List<Integer> ans = new ArrayList();
        ArrayList<Triple> list = new ArrayList();
        for(int i=0;i<start.length;i++)
            list.add(new Triple(start[i],end[i],i+1));
        Collections.sort(list,(o1,o2)-> o1.end-o2.end);
        int prevStart=-1;
        int prevEnd = -1;
        for(int i=0;i<list.size();i++)
        {
            if(prevStart==-1){
                prevStart = list.get(i).start;
                prevEnd = list.get(i).end;
                ans.add(list.get(i).pos);
            }
            else
            {
                if(list.get(i).start>prevEnd){
                prevStart = list.get(i).start;
                prevEnd = list.get(i).end;
                ans.add(list.get(i).pos);
                }
            }
        }
        return ans;
    }
}
