package tx;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        

        String[] strings = new String[n];
        for(int i = 0; i < n; i++) {
            strings[i] = sc.next();
        }
        //记录每行Y、O、U的数量
        int[] colsY = new int[n];
        int[] colsO = new int[n];
        int[] colsU = new int[n];
        //每列YOU的数量
        int[] rawY = new int[m];
        int[] rawO = new int[m];
        int[] rawU = new int[m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(strings[i].charAt(j) == 'o') {
                    colsO[i]++;
                    rawO[j]++;
                }
                else if(strings[i].charAt(j) == 'y') {
                    colsY[i]++;
                    rawY[j]++;
                }
                else if(strings[i].charAt(j) == 'u') {
                    colsU[i]++;
                    rawU[j]++;
                }
            }
        }
        int num = 0;
        int[][] you = new int[m][3];
        //记录当前行前包括当前行y,o,u的个数
        for(int i = 0; i < n; i++) {
            int y, o, u;
            y = o = u = 0;
            // int[] y = new int[4];
            // int[] o = new int[4];
            // int[] u = new int[4];

            for(int j = 0; j < m; j++) {
                if(strings[i].charAt(j) == 'o') {
                    o++;
                    you[j][1]++;
                    //当前为o，则找两边yu
                    // num +=
                }
                else if(strings[i].charAt(j) == 'y') {
                    y++;
                    you[j][0]++;
                    // num +=
                }
                else if(strings[i].charAt(j) == 'u') {
                    u++;
                    you[j][2]++;
                    // num +=
                }
            }
        }
        System.out.println(num);
    }
}
