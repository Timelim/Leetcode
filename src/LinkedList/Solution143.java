package LinkedList;

import java.util.HashMap;

public class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        HashMap<ListNode, ListNode> map = new HashMap();
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            map.put(cur, prev);
            cur = cur.next;
            prev = prev.next;
        }
        cur = prev;
        ListNode p = head;
        while (p != null) {
            cur.next = p.next;
            p.next = cur;
            p = p.next;
            if (p.next != null && p.next == cur) {
                break;
            }
            p = p.next;
            cur = map.get(cur);
            if (p.next != null && p.next == cur) {
                break;
            }
        }
        p = p.next;
        p.next = null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Solution143 s = new Solution143();
        s.reorderList(l1);
        ListNode p = l1;
        int i = 10;
        while (p != null && i > 0) {
            System.out.println(p.val);
            p = p.next;
            i--;
        }
    }
}