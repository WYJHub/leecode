package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCR084 {
    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, res, list, 0);

        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list, int idx) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            backtrack(nums, res, list, idx + 1);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        
    }
}
