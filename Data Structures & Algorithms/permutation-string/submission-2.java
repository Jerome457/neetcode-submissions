class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int window=s1.length();

        HashMap<Character,Integer> freq = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            freq.putIfAbsent(s1.charAt(i),0);
            freq.put(s1.charAt(i),freq.get(s1.charAt(i))+1);
        }
        HashMap<Character,Integer> freq2 = new HashMap<>();
        boolean once =true;

        for(int i=0;i<=s2.length()-window;i++){
            String s= s2.substring(i,i+window);
            if(once){
                for(int j=0;j<s.length();j++){
                    freq2.putIfAbsent(s.charAt(j),0);
                    freq2.put(s.charAt(j),freq2.get(s.charAt(j))+1);
                }
                once=false;
            }
            else{
                freq2.putIfAbsent(s2.charAt(i+window-1),0);
                freq2.put(s2.charAt(i+window-1),freq2.get(s2.charAt(i+window-1))+1);
                freq2.put(s2.charAt(i-1),freq2.get(s2.charAt(i-1))-1);
            }
            System.out.println(freq2);
            System.out.println(freq);
            boolean valid =true;
            for(int j=0;j<s1.length();j++){
                if(freq.get(s1.charAt(j))!=freq2.get(s1.charAt(j)))
                    valid=false;
            }
            if(valid)
                return valid;

        }
        return false;
    }
}
