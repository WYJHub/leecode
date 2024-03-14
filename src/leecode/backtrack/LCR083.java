package leecode.backtrack;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LCR083 {

    boolean[] vis;

    // public List<List<Integer>> permute(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     List<Integer> cur = new ArrayList<>();
    //     vis = new boolean[nums.length];
    //     // Arrays.sort(nums);
    //     backtrack(nums, res, 0, cur);
        
    //     return res;
    // }

    // public void backtrack(int[] nums, List<List<Integer>> res, int idx, List<Integer> cur) {
    //     if(cur.size() == nums.length) {
    //         res.add(new ArrayList<>(cur));
    //         return;
    //     }

    //     for(int i = 0; i < nums.length; i++) {
    //         if(!vis[i]) {
    //             vis[i] = !vis[i];
    //             cur.add(nums[i]);
    //             backtrack(nums, res, idx + 1, cur);
    //             vis[i] = !vis[i];
    //             cur.remove(cur.size() - 1);
    //             backtrack(nums, res, idx + 1, cur);
    //         }
    //     }
    // }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int num : nums) {
            list.add(num);
        }
        backtrack(list, res, 0);
        return res;
    }

    public void backtrack(List<Integer> list, List<List<Integer>> res, int cur) {
        if(cur == list.size() - 1) {
            res.add(new ArrayList<>(list));
            System.out.println(new ArrayList<>(list));
        }
        for(int i = cur; i < list.size(); i++) {
            Collections.swap(list, cur, i);
            backtrack(list, res, cur + 1);
            Collections.swap(list, i, cur);
        }
    }

    public static void main(String[] args) {
        // new LCR083().permute(new int[]{1,2,3});
        boolean[] visited = new boolean[10];
        System.err.println(visited[0]);
    }

}
