class Solution {
    public int trap(int[] height) {
        int vol=0;
        for(int i=0;i<height.length;i++){
            int leftMax=0;
            for(int j=i;j>=0;j--)
                leftMax=Math.max(leftMax,height[j]);
            int rightMax=0;
            for(int j=i;j<height.length;j++)
                rightMax=Math.max(rightMax,height[j]);
            vol+=Math.min(leftMax,rightMax)-height[i];
        }
        return vol;
    }
}