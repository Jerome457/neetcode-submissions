class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int u=nums.length-1;
        // int min=nums[0];
        int mid=0;
        while(l<u){
            mid=(l+u)/2;
            // min=Math.min(min,nums[mid]);

            if(nums[mid]<nums[u])
                u=mid;
            else
                l=mid+1;
        }
        return nums[l];
    }
}
