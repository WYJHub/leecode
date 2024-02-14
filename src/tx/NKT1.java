package tx;
import java.util.Scanner;

public class NKT1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();

        in.close();
        System.out.println(n);
        System.out.println(s);

        int[] indexes = new int[2];
        int[] val = new int[2];
        
        int[] dp = new int[n];
        dp[0] = 1;
        int pre = s.charAt(0) - '0';
        for(int i = 1; i < n; i++) {
            int cur = s.charAt(i) - '0';
            if(cur == pre) {
                val[cur]++;
                dp[i] = dp[i - 1] + val[cur] + 1;
            }
            else {
                
            }
        }
    }
}
