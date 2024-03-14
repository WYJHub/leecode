package leecode.dp;

import java.util.Arrays;

public class LCR091 {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[] dp = new int[3];
        for(int i = 0; i < 3; i++) {
            dp[i] = costs[0][i];
        }

        for(int i = 1; i < n; i++) {
            int[] dpNew = new int[3];
            for(int j = 0; j < 3; j++) {
                dpNew[j] = Math.min(dp[(j + 1) % 3], dp[(j + 2) % 3]) + costs[i][j];
            }
            dp = dpNew;

            Arrays.stream(dpNew).forEach(t->System.out.println(t));
        }

        int minCost = Math.min(dp[0], Math.min(dp[1], dp[2]));
        return minCost;
    }
}
