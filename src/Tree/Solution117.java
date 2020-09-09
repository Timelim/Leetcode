package Tree;

public class Solution117 {
    public Node connect(Node root) {
        if (root == null)
            return null;
        build(root, root.left, root.right);
        return root;
    }

    public void build(Node root, Node leftNode, Node rightNode) {
        if (leftNode == null)
            return;
        if (leftNode == root.left && root.right != null)
            leftNode.next = root.right;
        else {
            Node tmp = root.next;
            int flag = 0;
            if (leftNode.val == 7) {
                System.out.println(root.val);
                System.out.println(root.next.val);
                System.out.println(root.next.next.val);
            }

            while (tmp != null) {
                if (tmp.left != null) {
                    leftNode.next = tmp.left;
                    flag = 1;
                    break;
                } else if (tmp.right != null) {
                    leftNode.next = tmp.right;
                    flag = 1;
                    break;
                }
                tmp = tmp.next;
            }
            if (flag == 0) {
                leftNode.next = null;
            }
        }
        build(leftNode, leftNode.left);
        build(leftNode, leftNode.right);
    }
}
/*
[1,2,3,4,5,null,6,7,null,null,null,null,8]
 */