class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> freq= new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            freq.putIfAbsent(tasks[i],0);
            freq.put(tasks[i],freq.get(tasks[i])+1);
        }

        int completed= freq.size();
        int time=1;
        PriorityQueue<int[]> ready= new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        Deque<int[]> waiting= new ArrayDeque<>();
        for(Map.Entry<Character,Integer> a : freq.entrySet()){
            int [] temp={a.getValue(),a.getKey()};
             ready.add(temp);
        }

        while(completed !=0){
            if(!ready.isEmpty()){
                int temp[]= ready.poll();
                temp[0]--;
                if(temp[0]==0){
                    completed--;
                }
                else{
                    int temp2[]={time+n+1,temp[0],temp[1]};
                    waiting.add(temp2);
                }
                while(waiting.peekFirst()!=null && waiting.peekFirst()[0]==time+1){
                    temp= waiting.removeFirst();
                    int temp2[]={temp[1],temp[2]};
                    ready.add(temp2);
                }
            }
            else{
                int temp[]= waiting.removeFirst();
                if(time<temp[0])
                    time=temp[0];
                int temp2[]={temp[1],temp[2]};
                ready.add(temp2);
                continue;
            }
            time++;
        }
        return time-1;
    }
}
