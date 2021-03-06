package Sword;

public class Sword26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        return isSame(A, B)||isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean isSame(TreeNode t1, TreeNode t2) {
        if (t2 == null)
            return true;
        if (t1 == null || t1.val != t2.val)
            return false;
        return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);

    }
}
