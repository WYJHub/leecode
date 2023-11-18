package backtrack;

import java.util.ArrayList;
import java.util.List;

public class LCR079 {
    //枚举
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int mask = 0; mask < (1 << n); mask++) {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if( ((mask >> i) & 1) != 0) {
                    list.add(nums[i]);
                }
            }
            ans.add(list);
        }
        
        return ans;
    }
}
