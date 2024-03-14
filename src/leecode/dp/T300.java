package leecode.dp;

/*
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
子序列
。
 */
public class T300 {

    public int lengthOfLIS(int[] nums) {
        //1 <= nums.length <= 2500
        int n = nums.length, len = 1;
        //维护一个子数组，记录i长度时，最后一个数字的最小值
        int[] preMin = new int[n + 1];
        preMin[1] = nums[0];
        //由此定义，可以推断preMin为递增序列
        for(int i = 0; i < n; i++) {
            int cur = nums[i];
            if(cur > preMin[len]) {
                preMin[++len] = cur;
            }
            else {
                //如果当前值小于preMin[len],则需要在[1,len)中寻找到小于当前nums[i]的值,将当前最小值插入至前面
                int l = 1, r = len;
                while(l < r) {
                    int mid = (l + r) >>> 1;
                    if(preMin[mid] < cur) {
                        l = mid + 1;
                    }
                    else {
                        r = mid;
                    }
                }
                preMin[l] = cur;
            }
        }
        return len;
    }
}
