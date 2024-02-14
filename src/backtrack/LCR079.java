package backtrack;

import java.util.ArrayList;
import java.util.List;

//利用标记位来表示元素被选中的状态
public class LCR079 {


    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        List<List<Integer>> list = new ArrayList<>();
        list.add(a);
        a.remove(0);
        
        System.out.println(list.get(0).get(0));
    }
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if(cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }


    //枚举
    public List<List<Integer>> subsets1(int[] nums) {
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

    public void permute(int[] is) {
    }

}
