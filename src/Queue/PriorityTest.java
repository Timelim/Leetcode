package Queue;

import java.util.PriorityQueue;

public class PriorityTest {
    static class CNode{
        int val;
        char ch;

        public CNode(int val) {
            this.val = val;
            this.ch='a';
        }
    }
    public static void main(String[] args) {
        PriorityQueue<CNode> q=new PriorityQueue<CNode>((x,y)->y.val-x.val);
        q.offer(new CNode(10));
        q.offer(new CNode(8));
        q.offer(new CNode(4));
        q.offer(new CNode(23));
        System.out.println(q.peek().val);
    }
}
