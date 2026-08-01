class Solution {
    public int numDecodings(String s) {
        int [] cache= new int [s.length()+2];
        int n = s.length();
        cache[n]=1;
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            String number;
            int a=(ch-'0');
            if(i!=n-1)
            a=(ch-'0')*10+(s.charAt(i+1)-'0');
            if(ch=='0'){
                cache[i]=0;
                continue;
            }
            if(a>26){
                cache[i]=cache[i+1];
            }
            else
                cache[i]=cache[i+1]+cache[i+2];
        }
        return cache[0];
    }
}
