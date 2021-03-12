package leetcodeTop;

public class Leetcode8 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int revert = 0;
        while (x >= revert) {
            revert = revert * 10 + x % 10;
            x /= 10;
        }
//        System.out.println(revert);
//        System.out.println(x);
        return revert == x || revert/10 == x;
    }

    public static void main(String[] args) {
        Leetcode8 l=new Leetcode8();
        System.out.println(l.isPalindrome(121));
    }
}
