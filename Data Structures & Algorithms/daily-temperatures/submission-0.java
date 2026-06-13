class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int arr[]= new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            int dif=0;
            for(int j=i+1;j<temperatures.length;j++){
                if(temperatures[j]>temperatures[i]){
                    dif=j-i;
                    break;
                }
            }
            arr[i]=dif;
        }
        return arr;
    }
}
