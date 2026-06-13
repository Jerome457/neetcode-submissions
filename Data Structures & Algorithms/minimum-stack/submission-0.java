class MinStack {
    Stack<Integer> a;
    Stack<Integer> min;
    public MinStack() {
        a= new Stack<>();
        min=new Stack<>();
    }
    
    public void push(int val) {
        a.push(val);
        if(min.empty())
            min.push(val);
        else{
            min.push(Math.min(min.peek(),val));
        }
    }
    
    public void pop() {
        a.pop();
        min.pop();
    }
    
    public int top() {
        return a.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
