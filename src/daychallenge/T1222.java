package daychallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int kx = king[0], ky = king[1];
        List<List<Integer>> queenList = new ArrayList<>();
        Map<Integer, int[]> map = new HashMap<>();

        int sum = queens.length;
        for(int i = 0; i < sum; i++) {
            int x = queens[i][0] - kx, y = queens[i][1] - ky;
            if(x == 0 || y == 0 || Math.abs(x) == Math.abs(y)) {
                //三状态编码
                int key = sign(x) * 3 + sign(y);
                if(!map.containsKey(key) || map.get(key)[2] > Math.abs(x) + Math.abs(y)) {
                    map.put(key , new int[]{queens[i][0], queens[i][1], Math.abs(x) + Math.abs(y)});
                }
            }
        }
        
        for(int[] value : map.values()) {
            List<Integer> list = new ArrayList<>();
            list.add(value[0]);
            list.add(value[1]);
            queenList.add(list);
        }
        return queenList;
    }
    

    public int sign(int x) {
        if(x > 0) return 2;
        else if(x == 0) return 1;
        return 0;
    }
}
