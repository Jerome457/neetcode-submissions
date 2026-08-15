class Solution {
    public String longestPalindrome(String s) {
        int count=0;
        String max="";
        for(int j=0;j<s.length();j++){
            int left=j;
            int right=j;
            while(left>=0 && right< s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if(right-left+1>count){
                max=s.substring(left+1,right);
                count=right-left+1;
            }
            left=j;
            right=j+1;
            while(left>=0 && right< s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if(right-left+1>count){
                max=s.substring(left+1,right);
                count=right-left+1;
            }
        }
        return max;
    }
}
