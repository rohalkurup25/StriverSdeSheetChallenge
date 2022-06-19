import java.util.*;
public class Solution {
    static class Activity
    {
        int start;
        int end;
        Activity(int start,int end)
        {
            this.start = start;
            this.end = end;
        }
    }
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        if(start.size()==0)
            return 0;
        
        ArrayList<Activity> list = new ArrayList();
        
        for(int i=0;i<start.size();i++)
            list.add(new Activity(start.get(i),end.get(i)));
        
        Collections.sort(list,(o1,o2)->o1.end-o2.end);
        
        int maxAct = 1;
        int lastEnd = list.get(0).end;
        for(int i=1;i<list.size();i++)
        {
            if(list.get(i).start>=lastEnd)
            {
                maxAct++;
                lastEnd = list.get(i).end;
            }
        }
        return maxAct;
    }
}