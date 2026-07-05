class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int dRow[]={-1,1,0,0};
        int dCol[]={0,0,-1,1};
        Deque<int[]> q= new ArrayDeque<>();
        boolean visited[][]= new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0)
                    q.addLast(new int[]{i,j});
                if(grid[i][j]<=0)
                    visited[i][j]=true;
                else
                    visited[i][j]=false;
            }
        }


        while(!q.isEmpty()){
            int temp[]= q.removeFirst();

            for(int i=0;i<4;i++){
                int e=temp[0]+dRow[i];
                int f=temp[1]+dCol[i];

                if(isValid(visited,e,f)){
                    visited[e][f]=true;
                    q.addLast(new int []{e,f});
                    int distance=1+grid[temp[0]][temp[1]];
                    grid[e][f]=distance;
                }
            }
        }
        
    }

    boolean isValid(boolean vis[][],int i,int j){
        if(i<0||j<0||i>=vis.length||j>=vis[0].length)
            return false;
        if(vis[i][j])
            return false;
        
        return true;
    }
}
