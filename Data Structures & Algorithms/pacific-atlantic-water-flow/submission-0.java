class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> arr= new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                List<List<Integer>> a= new ArrayList<>();
                boolean b[]=dfs(heights,i,j,heights[i][j],a);
                if(b[0]&&b[1])
                    arr.add(new ArrayList<>(Arrays.asList(i,j)));
            }
        }
        return arr;
    }

    boolean[] dfs(int [][] heights, int i, int j,int prev,List visited){
        if(i<0||j<0||i>=heights.length||j>=heights[0].length)
            return new boolean[]{false,false};
        if(prev<heights[i][j])
            return new boolean[]{false,false};
        if(visited.contains(new ArrayList<>(Arrays.asList(i,j))))
            return new boolean[]{false,false};
        boolean p=false,a=false;
        if(i==0||j==0)
            p=true;
        if(i==heights.length-1||j==heights[0].length-1)
            a=true;
            
        visited.add(new ArrayList<>(Arrays.asList(i,j)));
        boolean[] down =dfs(heights,i+1,j,heights[i][j],visited);
        boolean[] up=dfs(heights,i-1,j,heights[i][j],visited);
        boolean[] right=dfs(heights,i,j+1,heights[i][j],visited);
        boolean[] left=dfs(heights,i,j-1,heights[i][j],visited);

        p |= down[0];
        a |= down[1];

        p |= up[0];
        a |= up[1];

        p |= right[0];
        a |= right[1];

        p |= left[0];
        a |= left[1];
        return new boolean[]{p, a};
    }
}
