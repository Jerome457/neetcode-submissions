class Solution {
    public int maxProduct(int[] nums) {
        int n= nums.length;
        int [] min = new int [n+2];
        int [] max = new int [n+2];
        min[n]=1;
        max[n]=1;
        int global=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            int a= nums[i]*max[i+1];
            int b= nums[i]*min[i+1];
            min[i]=Math.min(nums[i],Math.min(a,b));
            max[i]=Math.max(nums[i],Math.max(a,b));
            global=Math.max(global,max[i]);
            
        }
        return global;
    }
}
