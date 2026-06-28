class Solution {
    public int largestRectangleArea(int[] heights) {
        int max=0;
        Stack<Integer> stack= new Stack<>();
        Stack<Integer> ind= new Stack<>();
        for(int i=0;i<heights.length;i++){
            int start=i;
            while(!stack.isEmpty() && stack.peek()>heights[i]){
                int index=ind.pop();
                int height= stack.pop();
                max=Math.max(max,height*(i-index));
                start=index;
            }
            ind.push(start);
            stack.push(heights[i]);
        }
        
        while(!stack.isEmpty()){
            max=Math.max(max,stack.pop()*(heights.length-ind.pop()));
        }
        return max;
    }
}
