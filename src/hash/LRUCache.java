package hash;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache{
    
    private Map<Integer, DLinkedNode> cache;
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        DLinkedNode node = cache.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        //如果key存在，则更新value，移动节点至头
        if(cache.containsKey(key)) {
            DLinkedNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }
        //key不存在，创建节点，size++，若size > capacity，则删除尾节点
        else {
           DLinkedNode dLinkedNode = new DLinkedNode(key, value);
           cache.put(key, dLinkedNode);
           this.size++;
           addToHead(dLinkedNode);
           if(size > capacity) {
                //删除真尾节点
                DLinkedNode preTail = tail.prev;
                cache.remove(preTail.key);
                deleteNode(preTail);
                this.size--;
           }
        }
    }

    public void deleteNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    public void moveToHead(DLinkedNode node) {
        deleteNode(node);
        addToHead(node);
    }


}

class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;

    public DLinkedNode() {}

    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    } 
}