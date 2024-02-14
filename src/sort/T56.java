package sort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class T56 {
    //合并区间
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        ArrayList<int[]> res = new ArrayList<>();
        int n = intervals.length;
        res.add(new int[]{intervals[0][0], intervals[0][1]});
        for(int i = 1; i < n; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            int size = res.size();
            if(left > res.get(size - 1)[1]) {
                res.add(new int[]{left, right});
            }
            else {
                res.get(size - 1)[1] = Math.max(right, res.get(size - 1)[1]);
            }
        }
        n = res.size();
        int[][] mergeList = new int[n][2];
        for(int i = 0; i < n; i++) {
            mergeList[i][0] = res.get(i)[0];
            mergeList[i][1] = res.get(i)[1];
        }
        return mergeList;
    }
}
