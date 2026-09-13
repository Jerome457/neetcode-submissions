class Solution {
    public int jump(int[] nums) {
        int goal=nums.length-1;
        int count=0;
        int l=0,r=0;
        while(l<nums.length-1&&r<nums.length-1){
            int max=0;
            for(int i=l;i<=r;i++){
                max=Math.max(max,i+nums[i]);
            }
            if(r==max)
                break;
            l=r;
            r=max;

            count++;
        }
        return count;
    }
}
