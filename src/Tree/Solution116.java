package Tree;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
//常量级空间 不能用层次遍历
public class Solution116 {
    public Node connect(Node root) {
        if (root == null)
            return null;
        build(root, root.left);
        build(root, root.right);
        return root;
    }

    public void build(Node root, Node node) {
        if (node == null)
            return;
        if (node == root.left)
            node.next = root.right;
        else {
            if (root.next != null)
                node.next = root.next.left;
            else
                node.next = null;
        }
        build(node, node.left);
        build(node, node.right);
    }
}
