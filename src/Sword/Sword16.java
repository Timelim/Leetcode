package Sword;

public class Sword16 {
    public double myPow(double x, int n) {
        long a[]=new long [32];
        int cur=0;
        boolean flag=true;
        long tmp=n;
        if(n<0){
            tmp=-(long)n;
            flag=false;
        }
//        System.out.println(n);
//        System.out.println(tmp);
        while (tmp>0)
        {
            long i=1;
            while (i<=tmp){
                i*=2;
            }
            a[cur++]=i/2;
            tmp-=(i/2);
            //System.out.println(tmp);
        }

//        for(int i=0;i<cur;i++)
//            System.out.println(a[i]);
        double res=1;
        for(int i=cur-1;i>=0;i--){
            double tmp_x=x;
            for(long j=1;j<a[i];j*=2){
                tmp_x*=tmp_x;
            }
            if(flag==true){
                res*=tmp_x;
            }
            else{
                res*=1/tmp_x;
            }
        }
        return res;
    }

//    public double myPow(double x, int n) {
//        if(x == 0) return 0;
//        long b = n;
//        double res = 1.0;
//        if(b < 0) {
//            x = 1 / x;
//            b = -b;
//        }
//        while(b > 0) {
//            if((b & 1) == 1) res *= x;
//            x *= x;
//            b >>= 1;
//        }
//        return res;
//    }
    
    public static void main(String[] args) {
        Sword16 t= new Sword16();
        System.out.println(t.myPow(2.00000, -2147483648));
    }
}
/*
实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
 

说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */