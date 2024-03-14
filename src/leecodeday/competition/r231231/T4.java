package leecodeday.competition.r231231;

public class T4 {
    public boolean[] canMakePalindromeQueries(String s, int[][] queries) {
        int n = queries.length;
        int[] diff = new int[n / 2];
        boolean flag = true;
        for(int i = 0; i < n / 2; i++) {
            if(s.charAt(i) != s.charAt(n - i)) {
                diff[i] = 1;
            }
        }
        
        boolean[] res = new boolean[n];

        for(int i = 0; i < n; i++) {
            int a = queries[i][0], b = queries[i][1], c = queries[i][2], d = queries[i][3];

        }
        return res;
    }
}
