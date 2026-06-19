class LRUCache {
    int capacity;
    HashMap<Integer,Integer> a= new HashMap<>();
    LinkedList<Integer> b= new LinkedList<>();
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(a.get(key)==null){
            return -1;
        }
        else{
            int c=a.get(key);
            b.remove(Integer.valueOf(key));
            b.add(key);
            return c;
        }
    }
    
    public void put(int key, int value) {
        if(a.containsKey(key)){
            a.put(key,value);
            b.remove(Integer.valueOf(key));
        }
        else{
            if(a.size()>=capacity){
                a.remove(b.getFirst());
                b.removeFirst();
            }
            a.put(key,value);
        }
        b.add(key);
    }
}
