class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> diff= new HashMap<>();
        diff.put(nums[0],0);
        for(int i=1;i<nums.length;i++){
            if(diff.containsKey(target- nums[i])){

                return new int [] {diff.get(target- nums[i]),i};
            }
            diff.put(nums[i],i);
        }
        return null;
    }
}
