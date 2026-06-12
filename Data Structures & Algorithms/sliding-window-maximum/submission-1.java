class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int l=0;
        int arr[]= new int[nums.length-k+1];
        boolean once= true;
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){

            if(!once){
                pq.remove(nums[i-1]);
                pq.add(nums[i+k-1]);
            }
            if(once){
                for(int j=0;j<k;j++){
                    pq.add(nums[i+j]);
                }
                once=false;
            }
            arr[i]=pq.peek();
        }
        return arr;
    }
}
