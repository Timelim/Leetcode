package Sword;


public class Sword25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null & l2 == null) return null;

        ListNode cur=new ListNode(0);
        ListNode res = cur;
        ListNode p = l1;
        ListNode q = l2;
        System.out.println(p.val);
        System.out.println(q.val);
        while (q != null && p != null) {
            if (p.val < q.val) {
                res.next = p;
                p = p.next;
            } else {
                res.next = q;
                q = q.next;
            }
            res = res.next;
        }
        if (p != null) {
            res.next = p;
        }
        if (q != null) {
            res.next = q;
        }
        return cur.next;
    }
}
/*
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
示例1：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */