class TimeMap {
    HashMap<String,ArrayList<String[]>> a = new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        a.putIfAbsent(key,new ArrayList<>());

        String b[]={timestamp+"",value+""};
        a.get(key).add(b);

    }
    
    public String get(String key, int timestamp) {
        ArrayList<String[]> arr= a.get(key);
        if(!a.containsKey(key))
            return "";
        System.out.println(arr.get(0)[1]);
        int l=0;
        int u=arr.size()-1;
        int mid=0;
        while(l<=u){
            mid=(l+u)/2;
            String[] str= arr.get(mid);
            int time = Integer.parseInt(str[0]);
            if(time==timestamp){
                return str[1];
            }

            if(time>timestamp)
                u=mid-1;
            else
                l=mid+1;
        }

        if(u<0)
            return "";
        else{
            return arr.get(u)[1];
        }
    }
}
