class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> a= new ArrayList<>();
        dfs(new ArrayList<>(),a,s,0);
        return a;
    }

    void dfs(List<String> sub, List<List<String>> a,String s, int i){
        if(i>=s.length()){
            a.add(new ArrayList<>(sub));
            return;
        }

        for(int j=i;j<s.length();j++){
            String str=s.substring(i,j+1);
            if(isPalin(str)){
                sub.add(str);
                dfs(sub,a,s,j+1);
                sub.remove(sub.size()-1);
            }
        }
    }

    boolean isPalin(String s){
        for(int i=0;i<s.length()/2;i++)
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
                return false;
        return true;
    }
}
