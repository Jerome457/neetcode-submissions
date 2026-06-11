class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int max=0;
        int maxfreq=0;

        HashMap<Character,Integer> freq= new HashMap<>();
        for(int i=0;i<s.length();i++){

            freq.putIfAbsent(s.charAt(i),0);
            freq.put(s.charAt(i),freq.get(s.charAt(i))+1);
            maxfreq=Math.max(maxfreq,freq.get(s.charAt(i)));
            if((i-l+1)-maxfreq>k){
                freq.put(s.charAt(l),freq.get(s.charAt(l))-1);
                l++;
            }
            max=Math.max(i-l+1,max);
        }
        return max;
    }
}
