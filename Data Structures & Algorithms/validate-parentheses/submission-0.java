class Solution {
    public boolean isValid(String s) {
        Stack<Character> a = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(ch=='('|| ch=='{'|| ch=='['){
                a.push(ch);
            }
            else if(ch==')'|| ch=='}'|| ch==']')
            { 
                if(a.empty())
                    return false;
                char ch2= a.peek();
                if ((ch==')'&& ch2=='(')
                        || (ch=='}'&& ch2=='{')|| (ch==']'&& ch2=='[')){
                    a.pop();        
                }
                else
                    return false;
            }
            else
                a.push(ch);
        }
        if(a.empty())
            return true;
        else
            return false;
    }
}
