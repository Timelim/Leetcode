package LinkedList;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(0);
        ListNode p = res;
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len += 1;
            cur = cur.next;
        }
        cur = head;
        ListNode q;
        while (len >= k) {
            for (int i = 0; i < k; i++) {

                q = cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = q;

            }
            while (p.next != null)
                p = p.next;
            len -= k;
        }
        p.next = cur;
        res = res.next;
//        while (res != null) {
//            System.out.println(res.val);
//            res = res.next;
//        }
        return res;
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
        Solution25 s = new Solution25();
        s.reverseKGroup(l4, 2);
    }
}
