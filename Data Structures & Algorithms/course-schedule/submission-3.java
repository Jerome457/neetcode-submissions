class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            boolean[] visited = new boolean [numCourses];
            if(dfs(prerequisites,i,visited))
                return false;
        }
        return true;
    }

    boolean dfs(int [][]prerequisites,int course, boolean[]visited){
        boolean cycle=false;
        for(int i=0;i<prerequisites.length;i++){
            if(prerequisites[i][1]==course){
                if(visited[course])
                    return true;
                else{
                    visited[course]=true;
                    cycle= dfs(prerequisites,prerequisites[i][0],visited);
                    if(cycle)
                        return true;
                    else
                        visited[course]=false;
                }
            }
        }
        return false;

    }
}
