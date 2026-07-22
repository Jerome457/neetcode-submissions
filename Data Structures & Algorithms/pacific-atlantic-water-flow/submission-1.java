class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> arr= new ArrayList<>();
        boolean pacific[][]= new boolean[heights.length][heights[0].length];
        boolean atlantic[][]= new boolean[heights.length][heights[0].length];
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(i==0||j==0){
                    dfs(heights,i,j,heights[i][j],pacific);
                }

                if(i==heights.length-1||j==heights[0].length-1){
                    dfs(heights,i,j,heights[i][j],atlantic);
                }
            }
        }

        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j]&&atlantic[i][j])
                    arr.add(new ArrayList<>(Arrays.asList(i,j)));
            }
        }
        return arr;
    }

    void dfs(int [][] heights, int i, int j,int prev,boolean ocean[][]){
        if(i<0||j<0||i>heights.length-1||j>heights[0].length-1)
            return;
        if(ocean[i][j])
            return;
        if(prev<=heights[i][j]){
            ocean[i][j]=true;
        }

        if(ocean[i][j]){
            dfs(heights,i+1,j,heights[i][j],ocean);
            dfs(heights,i-1,j,heights[i][j],ocean);
            dfs(heights,i,j+1,heights[i][j],ocean);
            dfs(heights,i,j-1,heights[i][j],ocean);
        }
    }
}
