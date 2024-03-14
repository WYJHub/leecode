package leecode.dp;

public class LCR092 {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int dp0 = s.charAt(0) - '0', dp1 = 1 - dp0;
        for(int i = 1; i < n; i++) {
            int newDp0 = s.charAt(i) == '0' ? dp0 : dp0 + 1;
            int newDp1 = s.charAt(i) == '0' ? Math.min(dp0, dp1) + 1 : Math.min(dp0, dp1);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        
        return Math.min(dp0, dp1);
    }
}
