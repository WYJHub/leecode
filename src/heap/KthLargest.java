package heap;

import java.util.PriorityQueue;

public class KthLargest {

    //寻找第k大的元素
    //该题只有add，没有remove，所以较为简单
    PriorityQueue<Integer> queue;
    int k;
    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        this.k = k;
        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        queue.offer(val);
        if(queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }


    //如果考虑删减操作？
    //在add中不能只保留k个元素，必须全部存下来

    // public static void main(String[] args) {
    //     PriorityQueue<Integer> q = new PriorityQueue<>();
    //     q.offer(1);
    //     q.offer(12);
    //     q.offer(13);
    //     q.offer(142);
    //     q.offer(14);
    //     System.out.println(q.poll());
    //     System.out.println(q.poll());
    //     System.out.println(q.poll());
    //     System.out.println(q.poll());
    //     System.out.println(q.poll());
    // }
}
