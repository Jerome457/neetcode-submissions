class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> a= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            a.add(nums[i]);
        }

        if(a.size()<nums.length)
            return true;
        else
            return false;
    }
}