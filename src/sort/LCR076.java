package sort;

import java.util.PriorityQueue;

public class LCR076 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int num : nums) {
            queue.add(num);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        
        return queue.poll();
    }

    public static void main(String[] args) {
        new LCR076().findKthLargest(null, 0);
    }
}
