package leecode.hash;

//采用Hash+双向链表设计

//put(key, value) --> O(1)  需要hash

//然后需要在O(1)的时间内找到当前容量内最少被使用的将其删除，且需要将当前节点移动到链表首部 需要双向链表
//单向链表在删除尾节点时效率较低
public class LRU {
    static {
        System.out.println("静态初始化块执行了");
    }

}
