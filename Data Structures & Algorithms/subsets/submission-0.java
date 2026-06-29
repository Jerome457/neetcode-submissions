class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> a= new ArrayList<>();
        backtrack(0,nums,a,new ArrayList<>());
        return a;
    }

    void backtrack(int index, int [] nums, List<List<Integer>> a,List<Integer> subset){
        
        if(index==nums.length){
            a.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        backtrack(index+1,nums,a,subset);
        subset.remove(subset.size()-1);
        backtrack(index+1,nums,a,subset);
    }
}
