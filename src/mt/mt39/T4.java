package mt.mt39;
import java.util.Scanner;


public class T4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        
        int methods = 0;
        int[] a = new int[n];
        //pre2[i]表示前i个元素的前缀和
        int[] pre2 = new int[n + 1];
        int[] pre5 = new int[n + 1];

        int count2 = 0, count5 = 0;
        for(int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            int temp = a[i];
            //判断当前数字能否被2、5整除
            while(temp % 2 == 0) {
                count2++;
                temp = temp / 2;
            }
            while(temp % 5 == 0) {
                count5++;
                temp = temp / 5;
            }
            pre2[i + 1] = count2;
            pre5[i + 1] = count5;
        }
        // System.out.println(all2 + " " + all5);
        //至少要有k个0,即all2 >= k && all5 >= k
        if(count2 < k && count5 < k) {
            System.out.println(0);
        }
        else {
            for(int left = 0, right = 0; left < n; left++) {
                while(right < n) {
                    int range2 = pre2[right + 1] - pre2[left];
                    int range5 = pre5[right + 1] - pre5[left];
                    if(count2 - range2 < k || count5 - range5 < k) {
                        break;
                    }
                    right++;
                }
                // System.out.println("范围:" + left + " " + right);
                methods += (right - left);
                //每个滑窗记录以left为首元素的集合数量
            }
            System.out.println(methods);
        }
        
    }
}

/*
5 2
2 5 3 4 20
 */