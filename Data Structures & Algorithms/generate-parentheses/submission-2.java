class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> a= new ArrayList<>();

        backtrack(a,new StringBuilder(""),0,0,n);
        return a;
    }

    void backtrack(List<String> a,StringBuilder s,int open,int closed,int n){

        if(open==n && closed ==n){
            a.add(s.toString());
            return;
        }
        if(open<closed || open> n || closed>n)
            return;

        s.append("(");
        backtrack(a,s,open+1,closed,n);
        s.deleteCharAt(s.length()-1);
        s.append(")");
        backtrack(a,s,open,closed+1,n);
        s.deleteCharAt(s.length()-1);
    }
}
