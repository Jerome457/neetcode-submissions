class Solution {
    public List<Integer> partitionLabels(String s) {
        int ind[][]= new int[26][2];

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int index=(int)ch-97;
            if(ind[index][0]==0){
                ind[index][0]=i;
                ind[index][1]=i;
            }
            else{
                ind[index][1]=i;
            }
        }

        List<Integer> arr= new ArrayList<>();
        int start=0;
        int goal=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int index=(int)ch-97;
            goal=Math.max(ind[index][1],goal);
            if(i==goal){
                arr.add(goal-start+1);
                start=i+1;
            }
        }
        return arr;
    }
}
