package base;

public class ListNodeSort {
    public ListNode sort(ListNode head){
        ListNode p=head;
        ListNode q=head.next;
        p.next=null;
        //ListNode in1=q;
        while (q!=null){
//            System.out.println(q.val);
            ListNode m=p;
            ListNode n=p.next;
            while (n!=null){
                if(q.val>n.val){
                    m=m.next;
                    n=n.next;
                }
                else{
                    break;
                }
            }
            ListNode tmp=new ListNode(q.val);
            if(tmp.val>m.val){
                m.next=tmp;
                tmp.next=n;
            }
            else{
                tmp.next=m;
                p=tmp;
            }
//            ListNode head1=p;
//            while (head1!=null){
//                System.out.println(head1.val);
//                head1=head1.next;
//            }
//            System.out.println("------");
            q=q.next;
        }
        return p;
    }

    //链表的插入排序
    public static void main(String[] args) {
        ListNode t1=new ListNode(9);
        ListNode t2=new ListNode(3);
        ListNode t3=new ListNode(20);
        ListNode t4=new ListNode(15);
        ListNode t5=new ListNode(7);
        t1.next=t2;
        t2.next=t3;
        t3.next=t4;
        t4.next=t5;
        ListNodeSort a=new ListNodeSort();
        ListNode head=a.sort(t1);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
