class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1)
            return false;
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int a= edges[i][0];
            int b=edges[i][1];
            graph.putIfAbsent(a,new ArrayList<>());
            graph.get(a).add(b);
            graph.putIfAbsent(b,new ArrayList<>());
            graph.get(b).add(a);
        }

        int [] visited = new int [n];
        boolean cycle= dfs(graph,visited,0,-1);
        if(cycle)
            return false;
        for(int i=0;i<n;i++){
            if(visited[i]!=2)
                return false;
        }
        return true;
    }

    boolean dfs(HashMap<Integer,List<Integer>> graph,int [] visited,int i,int pred){
        if(visited[i]==2)
            return false;
        if(visited[i]==1){
            return true;
        }
        else{
            visited[i]=1;
            boolean cycle=false;
            if(graph.get(i)!=null)
            for(int a: graph.get(i)){
                if(a==pred)
                    continue;
                cycle=dfs(graph,visited,a,i);
                if(cycle)
                    break;
            }
            visited[i]=2;
            return cycle;
        }
    }
}
