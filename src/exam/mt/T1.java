package exam.mt;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int i = 0;
        double sumA = 0f, sumB = 0f;
        while (i++ < n) { // 注意 while 处理多个 case
            double a = in.nextDouble();
            double b = in.nextDouble();
            // System.out.println(a + b);
            sumA += a;
            sumB += b;
            //判断a相加，能否达到优惠券水平，然后减去优惠，或者全部折扣价
        }
        int x = in.nextInt();
        int y = in.nextInt();
        if(sumA >= x) {
            sumA -= y;
        }
        double res = Math.min(sumA, sumB);
        System.out.printf("%.2f", res);
        in.close();
    }
}
