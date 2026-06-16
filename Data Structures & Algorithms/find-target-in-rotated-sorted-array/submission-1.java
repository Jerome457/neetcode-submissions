class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int u=nums.length-1;

        while(l<u){
            int mid=(l+u)/2;

            if(nums[mid]== target)  
                return mid;
            
            if(nums[mid]<nums[u]){
                u=mid;
            }
            else
                l=mid+1;
        }
        System.out.println(l);
        int l1=0,u1=0;
        if(l==0){
            l1=0;
            u1=nums.length-1;
        }
        else if(target>=nums[0]){
            l1=0;
            u1=l-1;
        }
        else{
            l1=l;
            u1=nums.length-1;
        }

        while(l1<=u1){
            int mid=(l1+u1)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>target)
                u1=mid-1;
            else
                l1=mid+1;
        }
        return -1;
    }
}
