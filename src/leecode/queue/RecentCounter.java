package leecode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecentCounter {
    Deque<Integer> queue;
    int count;
    public RecentCounter() {
        this.queue = new ArrayDeque<>();
        this.count = 0;
    }
    
    public int ping(int t) {
        queue.offer(t);
        this.count++;
        while(queue.peek() < t - 3000) {
            queue.poll();
            this.count--;
        }
        return this.count;
    }
}
