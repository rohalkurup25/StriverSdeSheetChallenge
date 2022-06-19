/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/

import java.util.*;
public class Solution {
    static class Item
    {
        int wt;
        double val;
        double oneVal;
        
        Item(int wt,double val,double oneVal)
        {
            this.wt = wt;
            this.val = val;
            this.oneVal = oneVal;
        }
    }
    public static double maximumValue(Pair[] items, int n, int w) {
        double ans = 0;
        ArrayList<Item> list = new ArrayList();
        for(int i=0;i<n;i++)
        {
            int wt = items[i].weight;
            double val = (long)items[i].value; 
            list.add(new Item(wt,val,val/wt));
        }
        Collections.sort(list,(o1,o2)->
        {
            if(o1.oneVal>o2.oneVal)
                return -1;
            else if(o1.oneVal<o2.oneVal)
                return 1;
            else return 0;
        });
      
        for(Item item : list)
        {
            if(item.wt<=w){
                ans+=item.val;
                w-=item.wt;
            }
            else
            {
                ans+=(item.oneVal*w);
                w = 0;
                break;
            }
                
        }
        return ans;
    }
}