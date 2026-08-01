class Solution {
    public int rob(int[] nums) {
        int [] cache= new int [nums.length+2];

        for(int i=nums.length-1;i>=0;i--){
            cache[i]=Math.max(nums[i]+cache[i+2],cache[i+1]);
        }
        return cache[0];
    }
}
