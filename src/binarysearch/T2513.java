package binarysearch;

public class T2513 {
    public static void main(String[] args) {
        // System.out.println(new T2513().minimizeSet(2, 7, 1, 3));
        // System.out.println(new T2513().gcd(10, 40));
        long x = (long) 715827882 * 5;
        System.out.println(x);
    }
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int left = 0, right = 2 * (uniqueCnt1 + uniqueCnt2);
        //求diversor的最小公倍数
        long lcm = (long) divisor1 * divisor2 / gcd(divisor1, divisor2);
        //最多只需要2*（cnt1 + cnt2）的空间
        int res = 0;
        while(left <= right) {
          int mid = ((right - left) / 2) + left;
          if(check(mid, divisor1, divisor2, uniqueCnt1, uniqueCnt2, lcm)) {
            // res= mid;
            right = mid - 1;
          }
          else {
            left = mid + 1;
          }
        }
        return left;
      }
  
      public boolean check(int value, int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2, long lcm) {
        return (value - value / divisor1) >= uniqueCnt1 && (value - value / divisor2) >= uniqueCnt2 
          && (value - value / lcm >= uniqueCnt1 + uniqueCnt2);
      }
  
      public int gcd(int a, int b) {
        if(a < b) {
            int t = a;
            a = b;
            b = t;
          }
        // while(a != 0) {
        //     int tmp = a;
        //     a = b % a;  // 余数成为新的除数
        //     b = tmp;
        // }
        while(a % b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return b;
      }
}
