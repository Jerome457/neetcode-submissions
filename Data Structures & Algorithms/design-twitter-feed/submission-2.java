class Twitter {
    HashMap<Integer, HashSet<Integer>> followMap= new HashMap<>();
    HashMap<Integer, List<int[]>> tweetMap= new HashMap<>();
    int count=0;
    
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId,new ArrayList<>());
        int temp[]={count,tweetId};
        tweetMap.get(userId).add(temp);
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        HashSet<Integer> followers= followMap.get(userId);
        if(followers!=null)
        for(Integer follower: followers){
            for(int[] a: tweetMap.get(follower)){
                pq.add(a);
            }
        }
        List<int[]>temp = tweetMap.get(userId);
        if(temp!=null)
        for(int[] a: temp){
            pq.add(a);
        }

        List<Integer> arr= new ArrayList<>();
        int i=0;
        while(!pq.isEmpty()){
            i++;
            arr.add(pq.poll()[1]);
            if(i==10)
                break;
        }
        return arr;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId!=followeeId){
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId!=followeeId)
        followMap.get(followerId).remove(followeeId);
    }
}
