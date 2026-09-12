class Solution {
    public int maxSubArray(int[] nums) {
        int dp[]=new int[nums.length+1];
        int sum=Integer.MIN_VALUE;
        int currSum=0;
        for(int i=0;i<nums.length;i++){
            if(currSum<0){
                currSum=nums[i];
            }
            else
                currSum+=nums[i];
            sum=Math.max(sum,currSum);
        }
        return sum;
    }
}
