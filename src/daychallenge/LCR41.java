package daychallenge;

import java.util.ArrayDeque;
import java.util.Queue;

public class LCR41 {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);

        System.out.println(queue.poll());
    }
}
