package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class Solution146 {
    class DLListNode {
        DLListNode prev;
        DLListNode next;
        int key;
        int value;

        public DLListNode() {
        }

        public DLListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, DLListNode> map = new HashMap<>();
    int capacity;
    int size;
    DLListNode head, tail;

    public Solution146(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new DLListNode();
        tail = new DLListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLListNode node = map.get(key);
        if (node == null)
            return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLListNode node = map.get(key);
        if (node == null) {
            DLListNode newNode = new DLListNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DLListNode tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public void removeNode(DLListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(DLListNode node) {
        removeNode(node);
        addToHead(node);
    }

    public void addToHead(DLListNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public DLListNode removeTail() {
        DLListNode pre = tail.prev;
        removeNode(pre);
        return pre;
    }
}
/*
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
实现 LRUCache 类：

LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lru-cache
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */