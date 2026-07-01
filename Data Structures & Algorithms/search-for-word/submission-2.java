class Solution {
    boolean found=false;
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                HashSet<String> visited = new HashSet<>();
                backtrack(board,i,j,word,0,visited);
                if(found)
                    return found;
            }
        }
        return found;
    }

    
    void backtrack(char[][] board, int i, int j, String word,int index, HashSet<String> visited){
        if(index>=word.length()){
            found=true;
            return;
        }
        if(i>=board.length || j>= board[0].length|| i<0||j<0||found)
            return;
        
        if(visited.contains(i+","+j)) return ;
        char temp=word.charAt(index);
        if(board[i][j]==temp){
            visited.add(i+","+j);
            backtrack(board,i+1,j,word,index+1,visited);
            backtrack(board,i-1,j,word,index+1,visited);
            backtrack(board,i,j+1,word,index+1,visited);
            backtrack(board,i,j-1,word,index+1,visited);
            visited.remove(i+","+j);
        }
    }
}
