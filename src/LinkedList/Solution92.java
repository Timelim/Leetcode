package LinkedList;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        ListNode p = tmp;
        ListNode pre = tmp;
        for (int i = 0; i < left; i++) {
            if (i == 0) {
                p = p.next;
                continue;
            }
            p = p.next;
            pre = pre.next;
        }
        pre.next = null;
        ListNode cur = p.next;
        for (int i = left; i <= right; i++) {
            cur = p.next;
            p.next = pre.next;
            pre.next = p;
            p = cur;
        }
        while (pre.next != null)
            pre = pre.next;
        pre.next = cur;
        return tmp.next;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }


}
/*
给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */