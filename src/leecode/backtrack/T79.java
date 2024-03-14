package leecode.backtrack;

public class T79 {

    int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        //遍历board
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if(flag) {
                    return true;
                }
            }
        }
        return false;
    }

    //判断从x,y触发能否搜索到word[k:]
    public boolean check(char[][] board, boolean[][] visited, int x, int y, String word, int k) {
        if(board[x][y] == word.charAt(k)) {
            return false;
        }
        else if (k == word.length() - 1) {
            return true;
        }
        visited[x][y] = true;
        boolean res = false;

        for(int i = 0; i < 4; i++) {
            int tx = x + dir[i][0], ty = y + dir[i][1];
            if(tx >= 0 && tx < board.length && ty >= 0 && ty < board[0].length) {
                if(!visited[tx][ty]) {
                    boolean check = check(board, visited, tx, ty, word, k + 1);
                    if(check) {
                        res = true;
                        break;
                    }
                }
            }
        }
        visited[x][y] = false;
        return res;
    }
}
