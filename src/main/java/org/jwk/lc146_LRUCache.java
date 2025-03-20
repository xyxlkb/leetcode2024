package org.jwk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class lc146_LRUCache {
}

class LRUCache {
    // 双向链表的节点
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //插入的key和value都是存在node里的，用哈希表是为了快速定位
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode(); //使用伪头部和伪尾部节点
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) //如果key不存在，返回-1
            return -1;

        moveToHead(node); //每被访问一次，就把这个节点移到头部
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) { // 如果 key 不存在，创建一个新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode); // 添加到哈希表
            addToHead(newNode); // 添加到链表头部
            size++;

            if (size > capacity) { // 如果超出容量，移除链表尾部的节点
                DLinkedNode tailNode = removeTail();
                cache.remove(tailNode.key); // 从哈希表中移除
                size--;
            }
        } else {
            // 如果 key 存在，更新 value，并移到链表头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private DLinkedNode removeTail() {
        DLinkedNode tailNode = tail.prev; // 获取尾部节点
        removeNode(tailNode); // 移除节点
        return tailNode; // 返回被移除的节点
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */