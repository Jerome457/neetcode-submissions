class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> a = new Stack<>();

        for(int i=0;i<tokens.length;i++){
            String ch= tokens[i];

            if(ch.equals("+")||ch.equals("-")||ch.equals("/")|| ch.equals("*")){
                int a1=0;
                if(ch.equals("+"))
                    a1=a.pop()+a.pop();
                else if(ch.equals("-")){
                    int a2=a.pop();
                    int a3=a.pop();
                    a1=a3-a2;
                }
                else if(ch.equals("*"))
                    a1=a.pop()*a.pop();
                else{
                    int a2=a.pop();
                    int a3=a.pop();
                    a1=a3/a2;
                }
                a.push(a1);
            }
            else{
                a.push(Integer.parseInt(ch));
            }
        }
        return a.peek();
    }
}
