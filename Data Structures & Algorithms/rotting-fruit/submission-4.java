class Solution {

    public int orangesRotting(int[][] grid) {
        Deque<int[]> q= new ArrayDeque<>();
        int [] dRow={-1,1,0,0};
        int [] dCol={0,0,-1,1};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                    q.addLast(new int[]{i,j});
            }
        }
        int time=0;
        while(true){
            Deque<int[]> q2= new ArrayDeque<>();
            while(!q.isEmpty()){
                int temp[]=q.removeFirst();
                for(int i=0;i<4;i++){
                    int e= temp[0]+dRow[i];
                    int f= temp[1]+dCol[i];
                    if(isValid(grid,e,f)){
                        q2.addFirst(new int[]{e,f});
                        grid[e][f]=2;
                    }
                }
            }
            if(q2.isEmpty())
                break;
            time++;
            q.addAll(q2);
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return time;
    }

    boolean isValid(int[] [] grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length)
            return false;
        if(grid[i][j]==2||grid[i][j]==0)
            return false;
        return true;
    }
}
