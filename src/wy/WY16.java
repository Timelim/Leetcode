package wy;

import java.util.Arrays;
import java.util.Scanner;

public class WY16 {
    public static void main(String[] args) {
        int W,H;
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            W=scanner.nextInt();
            H=scanner.nextInt();
            int dp[][]=new int[W][H];
            for(int i=0;i<W;i++)
            Arrays.fill(dp[i],0);
//            dp[0][0]=0;
            int res=0;
            for(int i=0;i<W;i++){
                for(int j=0;j<H;j++){
                    if(dp[i][j]==0){
                        res+=1;
                        if(i+2<W) dp[i+2][j]=-1;
                        if(j+2<H) dp[i][j+2]=-1;
                    }
                }
            }
            System.out.println(res);
        }
    }

}
/*
二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
小易想知道最多可以放多少块蛋糕在网格盒子里。
输入描述:
每组数组包含网格长宽W,H，用空格分割.(1 ≤ W、H ≤ 1000)
输出描述:
输出一个最多可以放的蛋糕数
示例1
输入

3 2
输出

4
 */
