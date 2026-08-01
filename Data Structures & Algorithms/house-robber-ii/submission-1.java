    class Solution {
        public int rob(int[] nums) {
            int [] cache= new int [nums.length+1];
            int [] cache2= new int [nums.length+2];
            if(nums.length==1)
                return nums[0];
            for(int i=nums.length-2;i>=0;i--){
                cache[i]=Math.max(nums[i]+cache[i+2],cache[i+1]);
            }
            
            for(int i=nums.length-1;i>0;i--){
                cache2[i]=Math.max(nums[i]+cache2[i+2],cache2[i+1]);
            }
            return Math.max(cache[0],cache2[1]);
        }
    }
