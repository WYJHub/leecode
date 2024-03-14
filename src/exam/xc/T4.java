package exam.xc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class T4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        while(q-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int i = 0; i < n - 1; i++) {
                int u = in.nextInt(), v = in.nextInt();
                List<Integer> list = map.getOrDefault(u, new ArrayList<>());
                list.add(v);
                map.put(u, list);
                //双向边添加
                list = map.getOrDefault(v, new ArrayList<>());
                list.add(u);
                map.put(v, list);
            }
            //从1节点开始推断
            boolean[] visited = new boolean[n];
            // int res = dfs(0, visited, map);
        
            System.out.println("No");
        }
        
    }

    // public int dfs(int node, boolean[] visited, Map<Integer, List<Integer>> map) {
    //     //查看相邻节点是否为
    //     List<Integer> list = map.get(node);
    //     int count0 = 0, count1 = 0;
        
    // }
}
/*
2
4
1 2 2 3
1 2
2 3
3 4
4
1 2 3 3
1 2
2 3
2 4

输出

Yes
3
1 2
2 3
3 4
No
 */
