package SortAlgorithm;

public class Solution148 {
    //自底向上归并排序
    public ListNode sortList(ListNode head) {
        if (head == null)
            return head;
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length += 1;
            node = node.next;
        }
        ListNode resHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength *= 2) {
            ListNode prev = resHead;
            ListNode cur = resHead.next;
            while (cur != null) {
                ListNode head1 = cur;
                for (int i = 0; i < subLength && cur.next != null; i++) {
                    System.out.println(cur.val);
                    System.out.println("----");
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 0; i < subLength && cur.next != null; i++) {
                    System.out.println(cur.val);
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                prev.next = mergeTwoLists(head1, head2);
                while (prev.next != null)
                    prev = prev.next;
                cur = next;
            }
        }
        return resHead.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode index = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        if (l1 != null) {
            res.next = l1;
        } else {
            res.next = l2;
        }
        return index.next;
    }
}
/*
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
进阶：
    你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
