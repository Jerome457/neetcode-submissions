class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] cache= new int [cost.length];
        dp(0,cache,cost);
        System.out.println(Arrays.toString(cache)); 
        return Math.min(cache[0],cache[1]);
    }

    int dp(int i, int [] cache, int [] cost){
        if(i==cost.length)
            return 0;
        else if(i>cost.length)
            return Integer.MAX_VALUE;
        else if(cache[i]!=0){
            return cache[i];
        }
        cache[i]=Math.min(dp(i+1,cache,cost),dp(i+2,cache,cost))+cost[i];
        return cache[i];
    }
}
