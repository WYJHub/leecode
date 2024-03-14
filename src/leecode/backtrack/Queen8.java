package leecode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Queen8 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);

        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonalsLeft = new HashSet<>();
        Set<Integer> diagonalsRight = new HashSet<>();
        
        backtrack(solutions, queens, 0, n, columns, diagonalsLeft, diagonalsRight);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int row, int n, Set<Integer> columns, Set<Integer> diagonalsLeft, Set<Integer> diagonalsRight) {
        if(row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        }
        else {
            for(int i = 0; i < n; i++) {
                if(columns.contains(i)) {
                    continue;
                }
                //左斜线row + col相等
                //右斜线row - col相等
                //当前是选择第i列
                int left = row + i;
                if(diagonalsLeft.contains(left)) {
                    continue;
                }
                int right = row - i;
                if(diagonalsRight.contains(right)) {
                    continue;
                }
                //通过上述三个判断，说明当前位置可选，第row行选中第i列元素
                queens[row] = i;
                columns.add(i);
                diagonalsLeft.add(left);
                diagonalsRight.add(right);
                backtrack(solutions, queens, row + 1, n, columns, diagonalsLeft, diagonalsRight);
                queens[row] = -1;
                columns.remove(i);
                diagonalsLeft.remove(left);
                diagonalsRight.remove(right);
            }
        }
    }


    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
