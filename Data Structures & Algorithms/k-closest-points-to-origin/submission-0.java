class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq= new PriorityQueue<>((a,b)->Double.compare(a[0],b[0]));
        
        for(int i=0;i<points.length;i++){
            double [] a= new double [2];
            a[1]=i;
            a[0]=Math.sqrt(points[i][1]*points[i][1] + points[i][0]*points[i][0]);
            pq.add(a);
        }
        int [][] arr= new int[k][2];
        for(int i=0;i<k;i++){
            double [] a=pq.poll();
            arr[i]=points[(int)a[1]];
        }
        return arr;
    }
}
