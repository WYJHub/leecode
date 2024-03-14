package leecodeday.competition.r231231;

public class T1 {
    public boolean hasTrailingZeros(int[] nums) {
        int count = 0;
        for(int num : nums) {
            if(num % 2 == 0) {
                count += 1;
            }
        }
        return count >= 2;
    }
}
