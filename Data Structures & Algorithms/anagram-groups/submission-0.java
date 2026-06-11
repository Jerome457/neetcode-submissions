class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        ArrayList<List<String>> b= new ArrayList<List<String>>();   
        HashMap<String,List<String>> a = new HashMap<>();
        for(int i=0;i< strs.length;i++){
            int arr[]= new int [26];
            for(int j=0;j<strs[i].length();j++){
                arr[strs[i].charAt(j)-97]++;
            }
            String l= Arrays.toString(arr);

            a.putIfAbsent(l,new ArrayList<String>());   
            a.get(l).add(strs[i]);        }

        for(List<String> s : a.values()){
            b.add(s);
        }
        return b;
    }
}
