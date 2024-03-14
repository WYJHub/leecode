package leecode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCR082_r {
    List<List<Integer>> res;
    List<Integer> cur;

    public static void main(String[] args) {
        int[] candidates = new int[] {2,5,2,1,2};
        int target = 5;
        System.out.println(new LCR082_r().combinationSum2(candidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        cur = new ArrayList<>();
        //升序排序后，能够在当前索引对应值大于target时，直接返回
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int curIndex) {
        if(target == 0) {
            res.add(new ArrayList<>(cur));
        }
        if(curIndex == candidates.length || candidates[curIndex] > target) {
            return;
        }
        //查找从curIndex开始向后下一个不相同数字开始的索引
        int nextIndex = findNextIndex(candidates, curIndex);
        //记录选择当前数字次数
        int curCount = 0;
        //选择当前数字
        for(int i = curIndex; i < nextIndex; i++) {
            if(target < (i - curIndex + 1) * candidates[curIndex]) {
                break;
            }
            curCount++;
            cur.add(candidates[curIndex]);
            dfs(candidates, target - (i - curIndex + 1) * candidates[curIndex], nextIndex);
        }
        for(int i = 0; i < curCount; i++) {
            cur.remove(cur.size() - 1);
        }
        //未选择当前数字
        dfs(candidates, target, nextIndex);
    }

    public int findNextIndex(int[] candidates, int curIndex) {
        int index = curIndex;
        int n = candidates.length;
        while(index + 1 < n) {
            if(candidates[index + 1] != candidates[index]) {
                break;
            }
            index++;
        }
        if(candidates[index] == candidates[curIndex]) {
            return index + 1;
        }
        return index;
    }
}
