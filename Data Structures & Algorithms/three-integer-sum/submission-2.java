class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> a= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int l=i+1;
            int u=nums.length-1;
            int target=-nums[i];
            if(i>0 &&nums[i]==nums[i-1])
                continue;
            while(l<u){
                if(nums[l]+nums[u]>target)
                    u--;
                else if(nums[l]+nums[u]<target)
                    l++;
                else{
                    a.add(List.of(nums[l],nums[i],nums[u]));
                    while (l < u && nums[l] == nums[l + 1])
                        l++;

                    while (l < u && nums[u] == nums[u - 1])
                        u--;

                    l++;
                    u--;
                }
            }
        }
        return a;
    }
}
