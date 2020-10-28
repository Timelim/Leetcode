package Tree;

public class Solution117 {
    public Node connect(Node root) {
        if (root == null)
            return null;
        build(root);
        return root;
    }

    public void build(Node root) {
        Node leftNode = root.left;
        Node rightNode = root.right;

        if (leftNode != null && root.right != null) {
            leftNode.next = root.right;
        } else if (leftNode != null) {
            Node tmp = root.next;
            int flag = 0;
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


        if (rightNode != null) {
            Node tmp = root.next;
            int flag = 0;
            while (tmp != null) {
                if (tmp.left != null) {
                    rightNode.next = tmp.left;
                    flag = 1;
                    break;
                } else if (tmp.right != null) {
                    rightNode.next = tmp.right;
                    flag = 1;
                    break;
                }
                tmp = tmp.next;
            }
            if (flag == 0) {
                rightNode.next = null;
            }
        }
        if (rightNode != null) {
            build(rightNode);
        }
        if (leftNode != null) {
            build(leftNode);
        }

    }
}
/*
[1,2,3,4,5,null,6,7,null,null,null,null,8]
 */