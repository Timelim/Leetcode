package Problem;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        ListNode q = head;
        while (q != null) {

            p = p.next;
            if (q.next != null)
                q = q.next.next;
            else {
                return null;
            }
            if (p == q) {
                ListNode r = head;
                while (r != p) {
                    r = r.next;
                    p = p.next;
                }
                return p;
            }
        }
        return null;
    }
}
/*
 ----------->O
 环前长度是a，设快慢指针在环中b长度处相遇，剩余长度为c，慢指针走了 a+b，快指针走了a+n(b+c)=2(a+b)
   a=(n-1)(b+c)+c

 */
