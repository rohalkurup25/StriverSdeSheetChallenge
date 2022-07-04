import java.util.*;
public class Solution {

   static class Orange
    {
        int i;
        int j;
        Orange(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
    }
	public static int minTimeToRot(int[][] grid, int n, int m) {
        Queue<Orange> queue = new LinkedList();
		int rottenCount = 0;
        int nonRottenCount = 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    rottenCount++;
                    queue.add(new Orange(i,j));
                }
                else if(grid[i][j]==1)
                    nonRottenCount++;
            }
        }
        if(nonRottenCount==0)
            return 0;
        int time = 0;
        int processed = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            time++;
            for(int i=0;i<size;i++)
            {
                Orange orange = queue.remove();
                int x = orange.i;
                int y = orange.j;
                if(x+1<n && grid[x+1][y]==1)
                {
                    grid[x+1][y] = 2;
                    queue.add(new Orange(x+1,y));
                }
                if(x-1>=0 && grid[x-1][y]==1)
                {
                    grid[x-1][y] = 2;
                    queue.add(new Orange(x-1,y));
                }
                if(y+1<m && grid[x][y+1]==1)
                {
                    grid[x][y+1] = 2;
                    queue.add(new Orange(x,y+1));
                }
                if(y-1>=0 && grid[x][y-1]==1)
                {
                    grid[x][y-1] = 2;
                    queue.add(new Orange(x,y-1));
                }
            }
            processed+=queue.size();
            if(processed==nonRottenCount)
                return time;
        }
        return -1;
	}

}