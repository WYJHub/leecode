package exam.xc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        Long leftSum = 0L, rightSum = 0L;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            b[i] = a[i];
            rightSum += a[i];
        }
        in.close();
        Arrays.sort(b);
        HashMap<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            leftSum += b[i];
            rightSum -= b[i];
            Long res = (long)(i + 1) * b[i] - (long)leftSum + (long)rightSum - (long)(n - 1 - i) * (long)b[i];
            map.put(b[i], res);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(map.get(a[i]));
        }
    }
}
