package leecode.dp;

import java.util.Arrays;
import java.util.HashSet;

/*
416. 分割等和子集

给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class T416 {
    /*
    1 <= nums.length <= 200
    1 <= nums[i] <= 100
     */
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        int max = nums[0];
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(nums[i], max);
        }
        if(sum % 2 != 0) {
            return false;
        }
        if(2 * max > sum) {
            return false;
        }

        int target = sum / 2;
        //dp[i][j]表示使用nums[0-i]范围的元素能够
        boolean[][] dp = new boolean[n][target + 1];
        for(int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= target; j++) {
                if(j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n - 1][target];
    }

    //空间优化
    public boolean canPartition1(int[] nums) {
        int sum = 0, n = nums.length;
        int max = nums[0];
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(nums[i], max);
        }
        if(sum % 2 != 0) {
            return false;
        }
        if(2 * max > sum) {
            return false;
        }

        int target = sum / 2;
        //dp[i][j]表示使用nums[0-i]范围的元素能够
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        dp[nums[0]] = true;
        for(int i = 1; i < n; i++) {
            //因为使用的是上一层的数据，需要逆向更新，否则会使用到本层更新后的数据
            for(int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] | dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    public boolean canPartitional2(int[] nums) {
        int sum = 0, n = nums.length;
        int max = nums[0];
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(nums[i], max);
        }
        if(sum % 2 != 0) {
            return false;
        }
        if(2 * max > sum) {
            return false;
        }

        int target = sum / 2;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        set.add(nums[0]);
        for(int i = 1; i < n; i++) {
            HashSet<Integer> temp = new HashSet<>();
            for(int x : set) {
                temp.add(x + nums[i]);
                temp.add(x);
            }
            set = temp;
        }
        return set.contains(target);
    }
}
