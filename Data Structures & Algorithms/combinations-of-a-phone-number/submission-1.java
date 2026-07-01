class Solution {
    HashMap<Integer,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        char temp='a';
        for(int i=2;i<=9;i++){
            String s="";
            if(i==7|| i==9){
                s+= ""+temp+(char)(temp+1)+(char)(temp+2)+(char)(temp+3);
                temp=(char)(temp+4);
            }
            else{
                s+= ""+temp+(char)(temp+1)+(char)(temp+2);
                temp=(char)(temp+3);
            }
            map.put(i,s);
        }
        List<String> a= new ArrayList<>();
        if(digits.length()>0)
        backtrack(a,new StringBuilder(), digits,0);
        return a;
    }

    void backtrack(List<String> a, StringBuilder subset,String digits, int index){

        if(subset.length()==digits.length()){
            a.add(subset.toString());
            return;
        }

        if(index>=digits.length())  
            return;
        String set= map.get(Integer.parseInt(""+digits.charAt(index)));
        for(int i=0;i<set.length();i++){
            subset.append(set.charAt(i));
            backtrack(a,subset,digits,index+1);
            subset.deleteCharAt(subset.length()-1);
        }
    }
}
