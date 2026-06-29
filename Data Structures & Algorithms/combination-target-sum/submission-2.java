class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> a= new ArrayList<>();
        backtrack(nums,target,0,0,a,new ArrayList<>());
        return a;
    }

    void backtrack(int [] nums,int target,int sum, 
                    int index,List<List<Integer>> a,List<Integer> subset){
        if(index==nums.length|| sum>target){
            return;
        }
        if(sum==target){
            a.add(new ArrayList<>(subset));
            return;
        }
        
        subset.add(nums[index]);
        backtrack(nums,target,sum+nums[index],index,a,subset);
        subset.remove(subset.size()-1);
        backtrack(nums,target,sum,index+1,a,subset);

    }
}
