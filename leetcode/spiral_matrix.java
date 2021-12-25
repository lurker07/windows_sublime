import java.util.*;
class Solution {
    public static int left(int i,int j,List<Integer> res,int[][] matrix)
    {
        while(j>0)
        {
            j--;
            if(matrix[i][j]!=Integer.MIN_VALUE)
            {
                res.add(matrix[i][j]);
                matrix[i][j]=Integer.MIN_VALUE;
            }
            else
                return j+1;
        }
        return j;
    }
    public static int down(int i,int j,List<Integer> res,int[][] matrix)
    {
        while(i<matrix.length-1)
        {
            i++;
            if(matrix[i][j]!=Integer.MIN_VALUE)
            {
                res.add(matrix[i][j]);
                matrix[i][j]=Integer.MIN_VALUE;
            }
            else
                return i-1;
        }
        return i;
    }
    public static int up(int i,int j,List<Integer> res,int[][]matrix)
    { 
        while(i>0)
        {
            i--;
            if(matrix[i][j]!=Integer.MIN_VALUE)
            {
                res.add(matrix[i][j]);
                matrix[i][j]=Integer.MIN_VALUE;
            }
            else
                return i+1;
        }
        return i;
        
    }
    public static int right(int i,int j,List<Integer> res,int[][] matrix)
    { while(j<matrix[0].length-1)
        {
            j++;
            if(matrix[i][j]!=Integer.MIN_VALUE)
            {
                res.add(matrix[i][j]);
                matrix[i][j]=Integer.MIN_VALUE;
            }
            else
                return j-1;
        }
        return j;
        
    }
    public static  List<Integer> spiralOrder(int[][] matrix) 
    {
        List<Integer> res= new ArrayList<>();
        res.add(matrix[0][0]);
        matrix[0][0]=Integer.MIN_VALUE;
        int i=0,j=0,n=matrix.length,m=matrix[0].length;
        while(res.size()<(n*m))
        {

            j=right(i,j,res,matrix);
            System.out.println(res);
            i=down(i,j,res,matrix);
            System.out.println(res);
            j=left(i,j,res,matrix);
            System.out.println(res);
            i=up(i,j,res,matrix);
            System.out.println(res);
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] a={{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> res=spiralOrder(a);
        System.out.println(res);
    }
}