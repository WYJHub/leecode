package ali;

public class T1 {
    int n;
    int m;
    public static int getGoodArrayNum(int n, int m) {
        int[][] dp = new int[n + 1][n];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 1; k <= Math.min(m / i, n - 1); k++) {
                    dp[i][(j + k) % n] += dp[i - 1][j];
                }
            }
        }

        return dp[n][0];
    }

    public static void main(String[] args) {
        System.out.println(getGoodArrayNum(3, 100));
    }
}
