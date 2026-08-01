class Solution {
    public int rob(int[] nums) {
        int [] cache= new int [nums.length];
        int n=dp(0,nums,cache);
        System.out.println(Arrays.toString(cache));
        return n;
    }

    int dp(int n, int [] nums, int [] cache){
        if(n>=nums.length){
            return 0;
        }
        else if(cache[n]!=0){
            return cache[n];
        }

        cache[n]=Math.max(nums[n]+dp(n+2,nums,cache),dp(n+1,nums,cache));
        return cache[n];
    }
}
