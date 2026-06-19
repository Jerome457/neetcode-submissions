class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> a= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(a.contains(nums[i]))
                return nums[i];
            else
                a.add(nums[i]);
        }

        return -1;
    }
}
