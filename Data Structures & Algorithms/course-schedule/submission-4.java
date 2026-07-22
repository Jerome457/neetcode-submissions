class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> graph= new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            int a= prerequisites[i][0];
            int b= prerequisites[i][1];
            if(!graph.containsKey(a))
                graph.put(a,new ArrayList<>());
            graph.get(a).add(b);
        }
        
        int [] visited= new int[numCourses];
        for(int i=0;i<numCourses;i++){
            boolean cycle= dfs(graph,i,visited);
            if(cycle)
                return false;
        }
        return true;
    }

    boolean dfs(HashMap<Integer,List<Integer>> graph,int course, int[]visited){
        if(visited[course]==2)
            return false;
        else if(visited[course]==1)
            return true;
        else{
            boolean cycle=false;
            visited[course]=1;
            if(graph.get(course)!=null)
            for(int a : graph.get(course)){
                cycle=dfs(graph,a,visited);
                if(cycle)
                    break;
            }
            visited[course]=2;
            return cycle;
        }
    }
}
