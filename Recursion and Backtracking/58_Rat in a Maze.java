import java.util.*;
public class Solution {
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
       int [][]arr = new int[n][n];
        boolean vis[][] = new boolean[n][n];
       ArrayList<ArrayList<Integer>>  ans = new ArrayList();
        solve(maze,arr,n,ans,0,0);
        return ans;
    }
    
    
    public static void solve(int [][]maze,int [][]arr,int n,ArrayList<ArrayList<Integer>> ans,int i,int j)
    {
        if(i>=n || i<0 || j>=n || j<0 || maze[i][j]==0 || arr[i][j]==1)
            return ;
        if(i==n-1 && j==n-1 && maze[i][j]==1)
        {
            arr[i][j]=1;
            ArrayList<Integer> list = new ArrayList();
            for(int arr2[]:arr)
            {
                for(int x:arr2)
                {
                    list.add(x);        
                }
            }
            ans.add(list);
        }

        arr[i][j]=1;
        solve(maze,arr,n,ans,i+1,j);
        solve(maze,arr,n,ans,i,j+1);
        solve(maze,arr,n,ans,i,j-1);
        solve(maze,arr,n,ans,i-1,j);
        arr[i][j]=0;
    }
}