class Solution {

    public String encode(List<String> strs) {
        String a="";
        for(String s: strs){
            a=a+s.length()+"#"+s;
        }
        return a;
    }

    public List<String> decode(String str) {
        ArrayList<String> a= new ArrayList<>();
        for(int i=0;i<str.length();){
            String len="";
            while(true){
                char ch=str.charAt(i);
                if(ch=='#')
                    break;
                len+=ch;
                i++;
            }
            a.add(str.substring(i+1,i+Integer.parseInt(len)+1));
            i+=Integer.parseInt(len)+1;
        }
        return a;
    }
}
