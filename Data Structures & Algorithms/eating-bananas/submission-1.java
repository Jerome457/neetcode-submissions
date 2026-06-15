class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l=1;
        int u=0;
        for(int i=0;i<piles.length;i++)
            u=Math.max(piles[i],u);
        int min=Integer.MAX_VALUE;
        while(l<=u){
            int k=(l+u)/2;
            int cost=0;
            for(int i=0;i<piles.length;i++){
                cost+=Math.ceil((double)piles[i]/k);
            }
            if(cost>h)
                l=k+1;
            else{
                u=k-1;
                min=Math.min(min,k);
            }
        }
        return min;
    }
}
