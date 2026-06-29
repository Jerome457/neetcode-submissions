class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> a= new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,0,a,new ArrayList<>());
        return a;
    }

    void backtrack(int [] nums,int target,int sum, 
                    int index,List<List<Integer>> a,List<Integer> subset){
        if(sum==target){
            a.add(new ArrayList<>(subset));
            return;
        }
        if(index==nums.length|| sum>target){
            return;
        }
        
        subset.add(nums[index]);
        backtrack(nums,target,sum+nums[index],index+1,a,subset);
        subset.remove(subset.size()-1);
        while(index+1<nums.length&& nums[index]==nums[index+1])
            index++;
        backtrack(nums,target,sum,index+1,a,subset);

    }
}
