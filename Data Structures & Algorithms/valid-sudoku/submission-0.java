class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> b[]= new HashSet[9];

        for(int i=0;i<9;i++)
            b[i]=new HashSet<>();

        for(int i=0;i<board.length;i++){
            HashSet<Character> a= new HashSet<>();
            for(int j=0;j<board[i].length;j++){
                if(!Character.isDigit(board[i][j]))
                    continue;
                if(a.contains(board[i][j]))
                    return false;
                else
                    a.add(board[i][j]);

                if(b[j].contains(board[i][j])){
                    return false;
                }
                else
                    b[j].add(board[i][j]);
            }
        }

        for(int i=0;i<b.length;i++)
            b[i].clear();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                int row= (i/3)*3+j/3;
                if(!Character.isDigit(board[i][j]))
                    continue;
                if(b[row].contains(board[i][j]))
                    return false;
                else
                    b[row].add(board[i][j]);
            }
        }
        return true;
    }
}
