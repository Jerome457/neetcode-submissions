class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> freq= new HashSet<>();
        int max=0;
        int l=0;
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);

            if(freq.contains(ch)){
                while(s.charAt(l)!=ch){
                    freq.remove(s.charAt(l));
                    l++;
                }
                freq.remove(ch);
                l++;
            }
            freq.add(ch);
            max=Math.max(i-l+1,max);

        }
        return max;
    }
}
