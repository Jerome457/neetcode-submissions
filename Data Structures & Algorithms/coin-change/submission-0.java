class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount==0)
            return 0;
        int [] cache= new int[amount+1];
        return dp(amount,coins,cache);
    }

    int dp(int amount, int []coins, int [] cache){
        if(amount==0){
            return 0;
        }
        else if(amount<0){
            return -1;
        }
        else if(cache[amount]!=0){
            return cache[amount];
        }
        int a=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int b = dp(amount-coins[i],coins,cache)+1;
            if(b>0)
                a=Math.min(a,b);
        }
        if(a==Integer.MAX_VALUE)
            cache[amount]=-1;
        else
            cache[amount]=a;
        
        return cache[amount];
    }
}
