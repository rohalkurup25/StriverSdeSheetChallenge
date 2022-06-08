import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
     //   int arr[][] = new int[m][n];
      int[][] arr = mat.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        int startRow=0,startCol=0;
        int endRow=n-1,endCol=m-1;
        int prev=0,curr=0;
        while(startRow<endRow && startCol<endCol)
        {
          if(startRow>=endRow || startCol>=endCol)
              break;
           prev = arr[startRow+1][startCol];
           for(int i=startCol;i<=endCol;i++)
           {
               curr = arr[startRow][i];
               arr[startRow][i] = prev;
               prev = curr;
           }
            startRow++;
           for(int i=startRow;i<=endRow;i++)
           {
               curr = arr[i][endCol];
               arr[i][endCol] = prev;
               prev = curr;
           }
           endCol--;
           for(int i=endCol;i>=startCol;i--)
           {
               curr = arr[endRow][i];
               arr[endRow][i] = prev;
               prev = curr;
           }
           endRow--;
           for(int i = endRow;i>=startRow;i--)
           {
              curr = arr[i][startCol];
              arr[i][startCol] = prev;
              prev = curr;
           }
           startCol++;
        }
        
        for(int i=0;i<arr.length;i++)
        {
            ArrayList<Integer> list = new ArrayList();
            for(int j=0;j<arr[0].length;j++)
            {
                list.add(arr[i][j]);
            }
            mat.set(i,new ArrayList(list));
        }
        }
    
     
}