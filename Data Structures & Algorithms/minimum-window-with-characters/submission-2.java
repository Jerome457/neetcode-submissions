class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> freq = new HashMap<>();

        for(int i=0;i<t.length();i++){
            freq.putIfAbsent(t.charAt(i),0);
            freq.computeIfPresent(t.charAt(i),(key,oldvalue)->oldvalue+1);
        } 

        int l=0;
        int min=Integer.MAX_VALUE;
        String str="";
        int formed=0;
        HashMap<Character,Integer> arr=new HashMap<>();
        for(int i=0;i<s.length();i++){
            arr.putIfAbsent(s.charAt(i),0);
            arr.computeIfPresent(s.charAt(i),(key,oldvalue)->oldvalue+1);

            if(freq.get(s.charAt(i))!=null && arr.get(s.charAt(i))==freq.get(s.charAt(i)))
                formed++;

            if(formed==freq.size()){
                while(formed==freq.size()){
                    arr.put(s.charAt(l),arr.get(s.charAt(l))-1);
                    if(freq.get(s.charAt(l))!=null && arr.get(s.charAt(l))<freq.get(s.charAt(l)))
                        formed--;
                    l++;
                }
                System.out.println(arr);
                System.out.println(l+" "+i);
                if(min>i-l+1){
                    min=i-l+1;
                    System.out.println(min);
                    str=s.substring(l-1,i+1);
                }
            }
        }
        return str;
    }
}
