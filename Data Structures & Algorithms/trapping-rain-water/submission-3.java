class Solution {
    public int trap(int[] height) {
        int vol=0;
        int pref[] = new int[height.length];
        int suf[] = new int [height.length];
        pref[0]=height[0];
        suf[height.length-1]=height[height.length-1];

        for(int i=1;i<height.length;i++)
            pref[i]=Math.max(pref[i-1],height[i]);
        for(int i=height.length-2;i>=0;i--)
            suf[i]=Math.max(suf[i+1],height[i]);
        for(int i=0;i<height.length;i++){
            vol+=Math.min(pref[i],suf[i])-height[i];
        }
        return vol;
    }
}