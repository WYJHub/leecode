package exam.mt.mt39;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // int x = Integer.MAX_VALUE;
        // Long y = (long) (x) * 10;
        // System.out.println(y);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int q = in.nextInt();
        //计算总和,总计10E14
        Long all = 0L;
        int count0 = 0;
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if(a[i] == 0) {
                count0++;
            } else {
                all += a[i];
            }
        }
        
        while(q-- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            Long min = all + (long) (l) * count0;
            Long max = all + (long) (r) * count0;
            System.out.println(min + " " + max);
        }
        in.close();
    }
}
