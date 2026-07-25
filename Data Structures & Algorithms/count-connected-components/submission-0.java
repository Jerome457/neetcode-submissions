class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int a= edges[i][0];
            int b=edges[i][1];
            graph.putIfAbsent(a,new ArrayList<>());
            graph.get(a).add(b);
            graph.putIfAbsent(b,new ArrayList<>());
            graph.get(b).add(a);
        }
        boolean visited[]= new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(graph,visited,i);
            }
        }
        return count;
    }

    void dfs(HashMap<Integer,List<Integer>> graph, boolean visited[],int i){
        visited[i]=true;
        if(graph.get(i)!=null)
        for(int a:graph.get(i)){
            if(!visited[a])
                dfs(graph,visited,a);
        }
    }
}
