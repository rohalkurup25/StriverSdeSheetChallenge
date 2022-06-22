public class Solution {

	public static boolean isItSudoku(int matrix[][]) {
            for(int i=0;i<matrix.length;i++)
            {
                for(int j=0;j<matrix[0].length;j++)
                {
                    if(matrix[i][j]==0)
                    {
                        for(int c=1;c<=9;c++)
                        {
                            if(isPossible(matrix,i,j,c))
                            {
                                matrix[i][j]=c;
                                if(isItSudoku(matrix))
                                    return true;
                                matrix[i][j]=0;
                            }
                        }
                        return false;
                    }
                }
            }
        return true;
	}
    
    public static boolean isPossible(int [][]matrix,int r,int c,int val)
    {
        for(int i=0;i<9;i++)
        {
            if(matrix[r][i]==val || matrix[i][c]==val ||
              matrix[3*(r/3)+i/3][3*(c/3)+i%3]==val)
                return false;
        }
        return true;
    }
}