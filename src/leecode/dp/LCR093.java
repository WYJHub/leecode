package leecode.dp;

import java.util.HashMap;

public class LCR093 {
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer, Integer> arrIndex = new HashMap<>();
        int n = arr.length;
        System.out.println(n);
        for(int i = 0; i < n; i++) {
            arrIndex.put(arr[i], i);
        }

        int[][] dp = new int[n][n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i - 1; j >= 0 && 2 * arr[j] > arr[i]; j--) {
                int k = arr[i] - arr[j];
                int index = arrIndex.getOrDefault(k, -1);
                if(index >= 0) {
                    dp[j][i] = Math.max(dp[index][j] + 1, 3);
                    System.out.println("i:" + i + "j:" + j);
                    res = Math.max(res, dp[j][i]);
                }
            }
        }
        return res;
    }
}