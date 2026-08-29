class Solution {
    public int change(int amount, int[] coins) {
        int dp []= new int[amount+1];
        dp[0]=1;
        for(int j=0;j<coins.length;j++){
            for(int i=1;i<amount+1;i++){
                int a=i-coins[j];
                if(a>=0){
                    dp[i]+=dp[a];
                }
            }
        }
        return dp[amount];
    }
}
