class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        Arrays.sort(piles);
        int l=1;
        int u=piles[piles.length-1];
        int min=Integer.MAX_VALUE;
        while(l<=u){
            int k=(l+u)/2;
            int cost=0;
            for(int i=0;i<piles.length;i++){
                cost+=Math.ceil((double)piles[i]/k);
            }
            System.out.println(k+" "+cost);
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
