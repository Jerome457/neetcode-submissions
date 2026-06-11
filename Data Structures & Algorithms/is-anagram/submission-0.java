class Solution {
    public boolean isAnagram(String s, String t) {
        char arr1[]=s.toCharArray();
        char arr2[]=t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        String a = new String(arr1);
        String b= new String(arr2);
        if(a.equals(b))
            return true;
        else
            return false;
    }
}
