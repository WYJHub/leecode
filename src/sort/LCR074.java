package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LCR074 {
    public int[][] merge(int[][] intervals) {
        //List中不是基本数据类型，为引用类型，对get到的数据进行修改会作用在list中，而不是副本
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (in1, in2) -> {
            return in1[0] - in2[0];
        });
        list.add(intervals[0]);
        
        int n = intervals.length;
        for(int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            int[] pre = list.get(list.size() - 1);
            if(interval[0] <= pre[1]) {
                //左界由排序结果保证，右边界则需要重新比较
                pre[1] = Math.max(interval[1], pre[1]);
            }
            else {
                list.add(interval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        // List<int[]> list = new ArrayList<>();

        // list.add(new int[]{0, 1});
        // System.out.println(list.get(0)[0]);
        // int[] is = list.get(0);
        // is[0] = 2;
        // System.out.println(list.get(0)[0]);
        int[][] intervals = new int[][]{
            {1,3},{2,6}
        };
        int[][] merge = new LCR074().merge(intervals);

        for(int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0] + " " + merge[i][1]);
        }
        
        Integer a = 1;
        a.equals(1);
        Object[] arr = new Object[2];
        arr[0] = 1;
        arr[1] = "123";
    
    }
}
