public class Solution
{
public static int findMinimumCoins(int amount)
    {
        int minimumCash = 0;
        int i=0;
        int money[] = new int[]{1000,500,100,50,20,10,5,2,1};
        while(amount!=0)
        {
            if(money[i]<=amount)
            {
                minimumCash+=(amount/money[i]);
                amount = amount%money[i];
            }
            else
                i++;
        }
        return minimumCash;
    }
}