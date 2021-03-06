package Sword;

public class Sword44 {
    public int findNthDigit(int n) {
//        (10-0)*1
//        (10*10-10)*2
//        (10*10*10-100)*3
        if(n==0)
            return 0;
        if(n<10)
            return n;
        int num[]=new int[9];
        num[0]=0;
        num[1]=10;
        for(int i=2;i<9;i++){
            num[i]= (int) (num[i-1]+(Math.pow(10,i)-Math.pow(10,i-1))*i);
        }
//        for(int i=0;i<9;i++)
//            System.out.println(num[i]);
        int cin=0;
        for(int i=0;i<8;i++){
            if(n>num[i]&&n<=num[i+1]){
                cin=i+1;
                break;
            }
        }
        if(cin==0)
            cin=9;
        int count=(n-num[cin-1])/cin;
        int index = (n-num[cin-1])%cin;
        int curNum= (int) (Math.pow(10,cin-1)+count);
//        System.out.println(cin);
//        System.out.println(count);
//        System.out.println(index);
//        System.out.println(curNum);
        int res=0;
        for(int i=0;i<cin-index;i++){
            res=curNum%10;
            curNum/=10;
        }
        return res;
    }

    public static void main(String[] args) {
        Sword44 s= new Sword44();
        System.out.println( s.findNthDigit(11));
       ;
    }
}
/*
数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
请写一个函数，求任意第n位对应的数字。
示例 1：
输入：n = 3
输出：3
示例 2：
输入：n = 11
输出：0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */