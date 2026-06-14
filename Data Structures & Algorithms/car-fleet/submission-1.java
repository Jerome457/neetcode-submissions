class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        HashMap<Integer, Integer> arr = new HashMap<>();

        for(int i=0;i<position.length;i++)
            arr.put(position[i],speed[i]);
        int speed_new[]= new int [speed.length];
        Arrays.sort(position);
        for (int i = 0; i < position.length / 2; i++) {
            int temp = position[i];
            position[i] = position[position.length - 1 - i];
            position[position.length - 1 - i] = temp;
        }
        for(int i=0;i<speed.length;i++){
            speed[i]=arr.get(position[i]);
        }
        int count=0;
        for(int i=0;i<position.length;i++){
            System.out.println(position[i]+" "+speed[i]);
        }
        Stack<Integer> a= new Stack<>();
        for(int i=0;i<position.length;i++){
            if(a.empty()){
                a.push(i);
                count++;
                continue;
            }

            int diff= target-position[i];
            int index= a.peek();
            if((double)diff/speed[i]<=(double)(target-position[index])/speed[index]){

            }
            else{
                a.clear();
                a.push(i);
                count++;
            }
        }
        return count;
    }
}
