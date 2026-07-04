class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count=Math.max(count,dfs(grid,i,j));
                }
            }
        }
        return count;
    }
    int dfs(int board[][],int i,int j){
        if(i<0||j<0||i>=board.length||j>=board[0].length){
            return 0;
        }

        if(board[i][j]==1){
            board[i][j]=0;
            return 1+ dfs(board,i+1,j)+dfs(board,i-1,j)+dfs(board,i,j+1)+dfs(board,i,j-1);
        }
        return 0;
    }
}
