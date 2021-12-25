class Solution {
    public int totalNQueens(int n) {
     
        char[][] board= new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                board[i][j]='.';
        }
        char[] updiag= new char[2*n-1];
        char[] downdiag= new char[2*n-1];
        char[] rowcheck= new char[n];
        int count=0;
        dfs(0,board,count,updiag,downdiag,rowcheck);
        return count;
    }

   

    public boolean isValid(int row,int col,char[][] board,char[] updiag,char[] downdiag,char[] rowcheck)
    {
        if(rowcheck[row]=='Q'||updiag[row+col]=='Q'||downdiag[board.length-1+(col-row)]=='Q')
            return false;
        return true;
    }

    public int dfs(int col,char[][] board,int count,char[] updiag,char[] downdiag,char[] rowcheck)
    {
        if(col==board.length)
        return count+=1;;
        for(int i=0;i<board.length;i++)
        {
            if(isValid(i,col,board,updiag,downdiag,rowcheck))
            {
                rowcheck[i]='Q';
                updiag[i+col]='Q';
                downdiag[board.length-1+(col-i)]='Q';
                board[i][col]='Q';
                dfs(col+1,board,count,updiag,downdiag,rowcheck);
                board[i][col]='.';
                rowcheck[i]='.';
                updiag[i+col]='.';
                downdiag[board.length-1+(col-i)]='.';
            }
        }
        return count;
    }
}

