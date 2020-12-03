package Problem;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = new ListNode();
        ListNode q = new ListNode();
        p = head;
        q = head;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        if (p == null)
            return head.next;
        while (p.next != null) {
            q = q.next;
            p = p.next;
        }

        ListNode tmp = new ListNode();
        tmp = q.next;
        q.next = tmp.next;
        return head;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */