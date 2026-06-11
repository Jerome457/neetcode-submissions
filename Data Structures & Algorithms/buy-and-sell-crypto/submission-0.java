class Solution {
    public int maxProfit(int[] prices) {
        int profit=Integer.MIN_VALUE;
        int minbp=prices[0];
        for(int i=1;i<prices.length;i++){
            profit=Math.max(prices[i]-minbp,profit);
            minbp=Math.min(minbp,prices[i]);
        }

        if(profit<0)
            return 0;
        else
            return profit;
    }
}
