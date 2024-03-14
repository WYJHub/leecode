package leecode.slidingwindow;
//.滑动窗口最大值

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class T239 {

    //单调队列
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0; i < k; i++) {
            //如果当前元素，大于等于队尾元素，丢弃队尾元素
            while(!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        //这样queue中保存的就是从最大值开始后，峰值点记录
        res[0] = nums[queue.peekFirst()];
        for(int i = k; i < n; i++) {
            while(!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            while(queue.peekFirst() < i - k + 1) {
                queue.pollFirst();
            }
            res[i - k + 1] = nums[queue.peekFirst()];
        }
        return res;
    }
    //时间复杂度(O(NlogN))，优先队列->堆，插入与删除均为LogN，共计N次操作，即NlogN
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //创建优先队列
        //使用优先队列的目的是方便取出当前队列中最大元素。 ---> 创建大顶堆
        //但是由于指定窗口范围为[i, i + k - 1]，队列中除了元素本身还需要存储元素索引，以确定当前堆顶元素索引是否在当前窗口内
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                if(pair1[0] != pair2[0]) {
                    return pair2[0] - pair1[0];
                }
                return pair2[1] - pair1[1];
            }
        });
        
        //队列初始化,放入k个元素
        for(int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        
        int[] res = new int[n - k + 1];
        res[0] = queue.peek()[0];
        for(int i = k; i < n; i++) {
            queue.offer(new int[]{nums[i], i});
            //查看堆顶元素是否属于当前框
            while(queue.peek()[1] < i - k + 1) {
                queue.poll();
            }
            res[i - k + 1] = queue.peek()[0];
        }
        return res;
    }
    public static void main(String[] args) {
        
    }
}