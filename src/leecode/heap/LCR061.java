package leecode.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LCR061 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });

        List<List<Integer>> ans = new ArrayList<>();

        int m = nums1.length;
        int n = nums2.length;

        //将nums1所有元素或前k和元素的下标加入，队列中
        for(int i = 0; i < Math.min(m, k); i++) {
            queue.offer(new int[]{i, 0});
        }
        
        while(k-- > 0 && !queue.isEmpty()) {
            int[] indexPair = queue.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[indexPair[0]]);
            list.add(nums2[indexPair[1]]);

            ans.add(list);

            if(indexPair[1] + 1 < n) {
                indexPair[1] += 1;
                queue.offer(indexPair);
            }
        }
        
        return ans;
    }
}
