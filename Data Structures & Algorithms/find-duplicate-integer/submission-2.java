class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> a= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]<0)
                return Math.abs(nums[i]);
            else
                nums[Math.abs(nums[i])-1]*=-1;
        }

        return -1;
    }
}
