class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU obj= new DSU(edges.length);
        int [] arr= new int[2];
        for(int i=0;i<edges.length;i++){
            if(!obj.union(edges[i][0]-1,edges[i][1]-1)){
                arr=edges[i];
                break;
            }
        }
        return arr;
    }
}

class DSU{
    int parent[];

    DSU(int size){
        parent= new int[size];

        for(int i=0;i<size;i++){
            parent[i]=i;
        }
    }

    int find(int i){
        if (parent[i]==i)
            return i;
        return find(parent[i]);
    }
    
    boolean union(int i, int j){
        int irep=find(i);
        int jrep=find(j);
        if(irep==jrep)
            return false;
        parent[irep]=jrep;
        return true;
    }
}
