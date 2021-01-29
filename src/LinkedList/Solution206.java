package LinkedList;

public class Solution206 {
    //头插法
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode p=head,q=p.next;
        ListNode res = new ListNode(1);
        p.next=null;
        res.next=p;
        while (q!=null){
            p=q;
            q=p.next;
            p.next=res.next;
            res.next=p;
        }
        return res.next;
    }
}
/*
反转一个单链表。
示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */