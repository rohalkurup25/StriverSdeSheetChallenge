public class Solution
{
    public static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {
        if(image[x][y]==newColor)
            return image;
        solve(image,x,y,image[x][y],newColor);
        return image;
    }
    
    public static void solve(int arr[][],int i,int j,int oldColor,int newColor)
    {
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]!=oldColor)
            return;
        arr[i][j] = newColor;
        solve(arr,i+1,j,oldColor,newColor);
        solve(arr,i-1,j,oldColor,newColor);
        solve(arr,i,j+1,oldColor,newColor);
        solve(arr,i,j-1,oldColor,newColor);
    }
}
