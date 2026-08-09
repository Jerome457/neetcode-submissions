class Solution {
    public int maxProduct(int[] nums) {
        int n= nums.length;
        int min = nums[0];
        int max = nums[0];
        int global=nums[0];
        for(int i=1;i<n;i++){
            int a= nums[i]*max;
            int b= nums[i]*min;
            min=Math.min(nums[i],Math.min(a,b));
            max=Math.max(nums[i],Math.max(a,b));
            global=Math.max(global,max);
            
        }
        return global;
    }
}
