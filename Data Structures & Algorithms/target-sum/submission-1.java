class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        
        int [] dp = new int[2*(sum)+1];
        dp[sum]=1;
        for(int i=0;i<nums.length;i++){
            int [] next = new int[2*(sum)+1];
            for(int j=-sum;j<=sum;j++){
                int index= j+sum;
                if(dp[index]==0)    
                    continue;
                next[index+nums[i]]+=dp[index];
                next[index-nums[i]]+=dp[index];
            }
            dp=next;
        }

        // for(int j=0;j<dp.length;j++){
        //     System.out.println(dp[j]+" ");
        // }
        
        return dp[sum+target];
    }
}
