package LinkedList;

//做法  快慢指针加反转链表  ；存入数组；递归

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;

        ListNode p=head,q=head;
        while (q!=null){
            p=p.next;
            q=q.next;
            if(q==null)
                break;
            q=q.next;
        }
        ListNode s=reverseList(p);
        q=head;
        while (s!=null){
            System.out.printf("%d,%d",s.val,q.val);
            if(s.val!=q.val)
                return false;

            s=s.next;
            q=q.next;
        }
        return true;
    }
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
简单做法 入栈

请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */