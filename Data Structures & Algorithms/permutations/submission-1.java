class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> a= new ArrayList<>();
        boolean b[]= new boolean[nums.length];
        for(int i=0;i<nums.length;i++)
            b[i]=false;
        backtrack(b,nums,a,new ArrayList<>());
        return a;
    }

    void backtrack(boolean[] track,int [] nums, List<List<Integer>> a, List<Integer> subset){
        if(subset.size()==nums.length){
            a.add(new ArrayList<>(subset));
            return;
        }
        for(int i=0;i<track.length;i++){
            if(track[i]==true)
                continue;
            subset.add(nums[i]);
            track[i]=true;
            backtrack(track,nums,a,subset);
            subset.remove(subset.size()-1);
            track[i]=false;
            // backtrack(track,nums,a,subset);
        }
    }
}
