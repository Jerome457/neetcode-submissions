class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<stones.length;i++){
            a.add(stones[i]);
        }

        while(a.size()>1){
            int b= a.poll();
            int c=a.poll();
            if(b==c)
                continue;
            else
                a.add(b-c);
        }

        return a.peek()==null?0:a.poll();
    }
}
