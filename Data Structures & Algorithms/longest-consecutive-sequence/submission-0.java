class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> a= new HashSet<>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            a.add(nums[i]);
        }

        for(int i=0;i<nums.length;i++){
            if(!a.contains(nums[i]-1)){
                int j=nums[i];
                int count=0;
                while(true){
                    if(!a.contains(j))
                        break;
                    count++;
                    j++;
                }
                max=Math.max(max,count);
            }
        }
        return max;
    }
}
