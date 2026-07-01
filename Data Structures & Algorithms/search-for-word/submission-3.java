class Solution {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if (backtrack(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean backtrack(char[][] board, int i, int j, String word, int index, boolean[][] visited) {

        if (index >= word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        if (visited[i][j]) {
            return false;
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        boolean found =
                backtrack(board, i + 1, j, word, index + 1, visited) ||
                backtrack(board, i - 1, j, word, index + 1, visited) ||
                backtrack(board, i, j + 1, word, index + 1, visited) ||
                backtrack(board, i, j - 1, word, index + 1, visited);

        visited[i][j] = false; // backtrack

        return found;
    }
}