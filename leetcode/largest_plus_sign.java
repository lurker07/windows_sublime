class Solution {
    public static int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid= new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                grid[i][j]=1;
            }
        }
        for(int[] a:mines)
        {
            grid[a[0]][a[1]]=0;
        }
        int[][] left= new int[n][n];
        int[][] right= new int[n][n];
        int[][] up= new int[n][n];
        int[][] down= new int[n][n];
        for(int i=0;i<n;i++)
        {
            left[i][0]=grid[i][0];
            up[0][i]=grid[0][i];
            right[i][n-1]=grid[i][n-1];
            down[n-1][i]=grid[n-1][i];
        }
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    left[i][j]=left[i][j-1]+1;
                    System.out.println(left[i][j]+" "+i+" "+j+" "+left[i][j-1]);
                }
                if(grid[j][i]==1)
                {
                    up[j][i]=up[j-1][i]+1;
                }
                if(grid[i][n-j-1]==1)
                {
                   right[i][n-j-1]=right[i][n-j]+1;
                }
                if(grid[n-j-1][i]==1)
                {
                    down[n-j-1][i]=down[n-j][i]+1;
                }
                // else
                // {
                //     left[i][j]=0;
                //     up[j][i]=0;
                //     right[i][n-j-1]=0;
                //     down[n-j-1][i]=0;
                // }
            }
        }
        int max=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                max=Math.max(max,Math.min(left[i][j],Math.min(right[i][j],Math.min(up[i][j],down[i][j]))));
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print(left[i][j]);
            System.out.println();
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] a={{0,1},{1,0},{0,0}};
        System.out.println(orderOfLargestPlusSign(2,a));
    }
}