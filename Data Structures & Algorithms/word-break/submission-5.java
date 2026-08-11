class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] cache = new boolean [s.length()+1];
        cache[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(cache[j] && wordDict.contains(s.substring(j,i))){
                    cache[i]=true;
                    break;
                }
            }
        }
        return cache[s.length()];
    }
}
