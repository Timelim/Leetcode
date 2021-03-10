package leetcodeTop;

public class Leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode res = new ListNode(0);

        int cin = 0;
        ListNode cur = res;
        while (p != null && q != null) {
            int sum = p.val + q.val + cin;
            cur.next = new ListNode(sum % 10);
            cin = sum >= 10 ? 1 : 0;
            cur = cur.next;
            p = p.next;
            q = q.next;
        }
        while (p != null) {
            int sum = p.val + cin;
            cur.next = new ListNode(sum % 10);
            cin = sum >= 10 ? 1 : 0;
            cur = cur.next;
            p = p.next;
        }
        while (q != null) {
            int sum = q.val + cin;
            cur.next = new ListNode(sum % 10);
            cin = sum >= 10 ? 1 : 0;
            cur = cur.next;
            q = q.next;
        }
        if (cin == 1) {
            cur.next = new ListNode(1);
        }
        return res.next;
    }
}
/*
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.

 [2,4,9]
[5,6,4,9]
 */