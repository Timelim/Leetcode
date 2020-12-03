package Problem;

public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(0);
        ListNode index=res;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                res.next=l1;
                l1=l1.next;
            }
            else{
                res.next=l2;
                l2=l2.next;
            }
            res=res.next;
        }
        if(l1!=null){
            res.next=l1;
        }
        else{
            res.next=l2;
        }
        return index.next;
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
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */