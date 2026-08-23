class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
    int dist[]= new int[n+1];
    dist[k]=0;
    for(int i=0;i<n+1;i++){
        if(i==k)
            continue;
        dist[i]=Integer.MAX_VALUE;
    }

    HashMap<Integer,ArrayList<int[]>> graph = new HashMap<>();
    for(int i=0;i<times.length;i++){
        graph.putIfAbsent(times[i][0],new ArrayList<>());
        graph.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
    }

    pq.add(new int[]{0,k});

    while(!pq.isEmpty()){
        int [] arr=pq.poll();
        int d=arr[0];
        int u=arr[1];

        if(graph.get(arr[1])!=null)
        for(int [] a: graph.get(arr[1])){
            int v=a[0];
            int w=a[1];
            if(dist[u]+w<dist[v]){
                dist[v]=dist[u]+w;
                pq.add(new int[]{dist[v],v});
            }
        }
    }
    int sum=0;
    for(int i=1;i<n+1;i++){
        sum=Math.max(sum,dist[i]);
    }
    
    if(sum==Integer.MAX_VALUE)
        return -1;
    else
        return sum;
    }
}
