import java.util.*;
public class Solution {
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        int arr[][] = new int[n][n];       
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        solve(arr,0,ans); 
        return ans;
    }
    
    public static void solve(int [][]arr,int row,ArrayList<ArrayList<Integer>> ans)
    {
        if(row==arr.length)
        {
           ArrayList<Integer> list = new ArrayList();
           for(int i=0;i<arr.length;i++)
           {
            for(int j=0;j<arr.length;j++)
            {
                list.add(arr[i][j]);
            }
           } 
            ans.add(new ArrayList(list));
           return ; 
        }
        for(int i=0;i<arr.length;i++)
        {
            if(isPossible(arr,row,i))
            {
                arr[row][i] = 1;
                solve(arr,row+1,ans);
                arr[row][i] = 0;
            }
        }
        
    }
    
    public static boolean isPossible(int [][]arr,int row,int col)
    {
 
        int i1 = row-1;
        int j1 = col;
        while(i1>=0)
        {
            if(arr[i1--][j1]==1)
                return false;
        }
        j1 = col-1;
        i1 = row-1;
        while(i1>=0 && j1>=0)
        {
            if(arr[i1--][j1--]==1)
                return false;
        }
        i1 = row-1;
        j1 = col+1;
        while(i1>=0 && j1<arr.length)
        {
            if(arr[i1--][j1++]==1)
                return false;
        }
        return true;
    }
}