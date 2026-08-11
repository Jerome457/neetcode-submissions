class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] cache= new int[nums.length];
        cache[0]=0;
        int max=0;
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    cache[i]=Math.max(cache[i],cache[j]+1);
                }
            }
            max=Math.max(max,cache[i]);
        }
        return max+1;
    }
}
