class MedianFinder {
    PriorityQueue<Integer> pq1= new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> pq2= new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(pq1.peek()==null){
            pq1.add(num);
            return;
        }
        if(num<pq1.peek())
            pq1.add(num);
        else
            pq2.add(num);
        if(Math.abs(pq1.size()-pq2.size())>1){
            if(pq1.size()>pq2.size()){
                while(pq1.size()-pq2.size()>1)
                    pq2.add(pq1.poll());
            }
            else{
                while(pq2.size()-pq1.size()>1){
                    pq1.add(pq2.poll());
                }
            }
        }
    }
    
    public double findMedian() {
        int total=pq1.size()+pq2.size();
        if(total%2==0){
            return (pq1.peek()+pq2.peek())/2.0;
        }
        else{
            return (pq1.size()>pq2.size())?pq1.peek():pq2.peek();
        }
    }
}
