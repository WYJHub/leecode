package leecode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LCR060 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //保留前k个大的，用升序，优先出队小元素
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        for(int key : map.keySet()) {
            queue.offer(new int[]{key, map.get(key)});
            if(queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll()[0];
        }
        
        return res;
    }
}
