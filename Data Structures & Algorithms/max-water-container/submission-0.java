class Solution {
    public int maxArea(int[] heights) {
        int max=0;
        int l=0;
        int u=heights.length-1;

        while(l<u){
            max=Math.max(Math.min(heights[u],heights[l])*(u-l),max);

            if(heights[l]<heights[u])
                l++;
            else
                u--;
        }
        return max;
    }
}
