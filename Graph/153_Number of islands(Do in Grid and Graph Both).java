public class Solution 
{
    public static int getTotalIslands(int[][] mat) 
	{
        int count = 0;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==1)
                {
                    count++;
                    dfs(mat,i,j);
                }
            }
        }
        return count;
    }
    
    
    
    public static void dfs(int [][]arr, int i,int j)
    {
        if(i>=arr.length || j>=arr[0].length || i<0 || j<0 || arr[i][j]==0)
            return;
        arr[i][j]=0;
        dfs(arr,i-1,j);
        dfs(arr,i+1,j);
        dfs(arr,i,j-1);
        dfs(arr,i,j+1);
        dfs(arr,i-1,j-1);
        dfs(arr,i-1,j+1);
        dfs(arr,i+1,j-1);
        dfs(arr,i+1,j+1);
    }
}