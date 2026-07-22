class Solution {
    public void solve(char[][] board) {
        boolean[][] a= new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++)
            if(board[i][0]=='O')
                dfs(board,i,0,a);
        for(int i=0;i<board[0].length;i++)
            if(board[0][i]=='O')
                dfs(board,0,i,a);
        for(int i=0;i<board.length;i++)
            if(board[i][board[0].length-1]=='O')
                dfs(board,i,board[0].length-1,a);
        for(int i=0;i<board[0].length;i++)
            if(board[board.length-1][i]=='O')
                dfs(board,board.length-1,i,a);
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(board[i][j]=='O'&& !a[i][j])
                    board[i][j]='X';
    }

    void dfs(char[][]board,int i,int j, boolean[][]a){
        if(i<0||j<0||i>board.length-1||j>board[0].length-1||board[i][j]=='X'||a[i][j])
            return;
        
        a[i][j]=true;
        dfs(board,i+1,j,a);
        dfs(board,i-1,j,a);
        dfs(board,i,j+1,a);
        dfs(board,i,j-1,a);
    }
}
