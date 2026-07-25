class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            graph.putIfAbsent(prerequisites[i][0], new ArrayList<>());
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int visited[]= new int[numCourses];
        boolean cycle=false;
        List<Integer> arr= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            cycle=dfs(graph,visited,i,arr);
            if(cycle) 
                return new int [0];
        }

        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }

    boolean dfs(HashMap<Integer,List<Integer>> graph, int visited[], int i,List<Integer> arr){
        if(i>=visited.length||i<0||visited[i]==2)
            return false;
        if(visited[i]==1)
            return true;
        else{
            List<Integer> pre= graph.get(i);
            
            boolean cycle=false;
            if(pre!=null)
            for(Integer a: pre){
                visited[i]=1;
                cycle= dfs(graph,visited,a,arr);
                if(cycle)
                    break;
            }
            arr.add(i);
            visited[i]=2;
            return cycle;
        }
    }
}
