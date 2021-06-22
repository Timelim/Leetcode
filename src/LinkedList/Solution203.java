package LinkedList;

public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return null;
        ListNode p=head,q=p.next;
        while (p!=null&&p.val==val){
            q=p.next;
            p.next=null;
            p=q;
        }
        if(p==null)
            return null;
        ListNode res=p;
        q=p.next;
        while (q!=null){
            if(q.val==val){
                p.next=q.next;
                q.next=null;
                q=p.next;
            }
            else{
               q=q.next;
               p=p.next;
            }
        }
        return res;
    }
}
/*
给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */