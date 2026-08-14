class Solution {
    public int countSubstrings(String s) {
        int count=0;
        for(int j=0;j<s.length();j++){
            int left=j;
            int right=j;
            while(left>=0 && right< s.length() && s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }
            left=j;
            right=j+1;
            while(left>=0 && right< s.length() && s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}
