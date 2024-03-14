package leecodeday.daychallenge;
// simple
public class LCP50 {
    public int giveGem(int[] gem, int[][] operations) {
        int n = operations.length;
        for(int i = 0; i < n; i++) {
            int toOther = gem[operations[i][0]] / 2;
            gem[operations[i][0]] -= toOther;
            gem[operations[i][1]] += toOther;
        }

        int min = gem[0], max = gem[1];
        for(int i = 0; i < gem.length; i++) {
            min = Math.min(min, gem[i]);
            max = Math.max(max, gem[i]);
        }
        return max - min;
    }
}
