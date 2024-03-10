package mt.mt39;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//小美拿到了一个n*n的矩阵，其中每个元素是 0 或者 1。
// 小美认为一个矩形区域是完美的，当且仅当该区域内 0 的数量恰好等于 1 的数量。
// 现在，小美希望你回答有多少个i*i的完美矩形区域。你需要回答1\leq i \leq n的所有答案。

// 输入描述
// 第一行输入一个正整数n，代表矩阵大小。
// 接下来的n行，每行输入一个长度为n的 01 串，用来表示矩阵。
// 1\leq n \leq 200

// 输出描述
// 输出n行，第i行输出i*i的完美矩形区域的数量。

public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] mat = new int[n + 1][n + 1];
        for(int i = 0; i < n; i++) {
            String row = in.next();
            //拆分串
            for(int j = 0; j < n; j++) {
                mat[i][j] = row.charAt(j) - '0';
                // System.out.print(mat[i][j]);
            }
        }
        //枚举i
        for(int i = 1; i <= n; i++) {
            if((i * i) % 2 != 0) {
                System.out.println(0);
                continue;
            }
            int target0 = (i * i) / 2;
            int cur0 = 0;
            //记录好矩阵数量
            int count = 0;
            //队列记录每一列0的数量
            Deque<Integer> queue = new ArrayDeque<>();

            for(int p = 0; p <= n - i; p++) {
                queue.clear();
                cur0 = 0;
                int cur = 0;
                //p行q列
                for(int q = 0; q < n; q++) {
                    //锁定为p -> p + i-1行
                    int curCol0 = 0;
                    for(int row = p; row <= p + i - 1; row++) {
                        // System.out.println(row + " " + q);
                        if(mat[row][q] == 0) {
                            curCol0++;
                        }
                    }
                    queue.add(curCol0);
                    cur0 += curCol0;
                    if(queue.size() >= i) {
                        if(cur0 == target0) {
                            count++;
                        }
                        cur0 -= queue.poll();
                        cur++;
                        // System.out.print(cur0 + " ");
                    }
                }
                // System.out.print(count + " ");
            }
            System.out.println(count);
        }
    }
}
