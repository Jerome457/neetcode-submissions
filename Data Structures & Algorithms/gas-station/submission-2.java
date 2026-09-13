class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remainder=0;
        int start=0;
        int n=gas.length;
        int sum=0;
        for(int i=0;i<gas.length;i++){
            int diff=gas[i]-cost[i];
            remainder+=diff;
            sum+=diff;
            if(remainder<0){
                remainder=0;
                start=(i+1)%n;
            }
        }
        if(sum<0)
            return -1;

        return start;
    }
}
