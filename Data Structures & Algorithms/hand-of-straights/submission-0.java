class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int prev=-1;
        if(hand.length%groupSize!=0)
            return false;
        int n=hand.length/groupSize;
        HashMap<Integer,Integer> freq= new HashMap<>();
        for(int i=0;i<hand.length;i++){
            freq.putIfAbsent(hand[i],0);
            freq.put(hand[i],freq.get(hand[i])+1);
        }
        
        int k=0;
        for(int i=0;i<hand.length;i++){
            if(freq.get(hand[i])==0)
                continue;
            
            for(int j=hand[i];j<hand[i]+groupSize;j++){
                int f=freq.getOrDefault(j,0);
                if(f==0)
                    return false;
                freq.put(j,freq.get(j)-1);
            }
        }

        return true;
    }
}
