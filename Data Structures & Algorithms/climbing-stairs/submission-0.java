class Solution {
    public int climbStairs(int n) {
        int cache[]= new int [n];

        return dp(0,n,cache);
    }

    int dp(int i,int n,int [] cache){
        if(i==n)
            return 1;
        else if(i>n)
            return 0;
        else if(cache[i]!=0){
            return cache[i];
        }
        
        cache[i]=dp(i+1,n,cache)+dp(i+2,n,cache);
        return cache [i];
    }
}
