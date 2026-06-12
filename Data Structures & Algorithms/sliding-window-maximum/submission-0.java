class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int l=0;
        int arr[]= new int[nums.length-k+1];
        for(int i=0;i<arr.length;i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<k;j++){
                max=Math.max(max,nums[i+j]);
            }
            arr[i]=max;
        }
        return arr;
    }
}
