package Sword;

public class Sword15 {
    public int cuttingRope(int n) {
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        if(n==4)
            return 4;
        long res=1;
        while (n>4){
            res*=3;
            res%=1000000007;
            n-=3;
        }
        return (int)(res*n%1000000007);
    }

    public static void main(String[] args) {
        Sword15 t =new Sword15();
        System.out.println(t.cuttingRope(10));
    }
}
/*
剑指 Offer 14- I. 剪绳子
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:
输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
提示：
2 <= n <= 58
1 2 3 4 5 6 7 8 9 10
1 2 3 4 6 9 12 18 27 36
 */