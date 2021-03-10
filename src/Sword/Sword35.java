package Sword;

import java.util.HashMap;

public class Sword35 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> nodeHashMap = new HashMap<>();
        Node p = head;
        while (p != null) {
            nodeHashMap.put(p, new Node(p.val));
        }
        p = head;
        while (p != null) {
            nodeHashMap.get(p).random = nodeHashMap.get(p.random);
            nodeHashMap.get(p).next = nodeHashMap.get(p.next);
            p = p.next;
        }
        return nodeHashMap.get(head);
    }
}
