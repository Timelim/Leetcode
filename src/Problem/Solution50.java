package Problem;

public class Solution50 {
    public double myPow(double x, int n) {
        if(x==0.0d) return 0.0d;
        long b=n;
        if(n<0){
            x=1/x;
            b=-b;
        }
        double res=1.0d;
        while(b!=0){
            if((b&1)==1){
                res*=x;
            }
            x*=x;
            b>>=1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution50 s=new Solution50();
        System.out.println(s.myPow(2.0,-2));
    }
}
/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
示例 1：

输入：x = 2.00000, n = 10
输出：1024.00000
示例 2：

输入：x = 2.10000, n = 3
输出：9.26100
示例 3：

输入：x = 2.00000, n = -2
输出：0.25000
解释：2-2 = 1/22 = 1/4 = 0.25

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/powx-n
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
