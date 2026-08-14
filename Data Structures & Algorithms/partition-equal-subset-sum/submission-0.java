class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        if(sum%2!=0)
            return false;
        else{
            int half=0;
            sum=sum/2;
            boolean arr[][] = new boolean[sum+1][nums.length+1];
            for(int i=0;i<nums.length+1;i++)
                arr[0][i]=true;
            for(int i=1;i<sum+1;i++){
                for(int j=1;j<nums.length+1;j++){
                    if(nums[j-1]<=i){
                        arr[i][j]=arr[i][j-1] || arr[i-nums[j-1]][j-1];
                    }
                    else
                        arr[i][j]=arr[i][j-1];
                }
            }
            
            return arr[sum][nums.length];

        }
    }
}
