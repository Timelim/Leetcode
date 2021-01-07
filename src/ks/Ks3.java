package ks;

import java.util.*;

public class Ks3 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int N = scanner.nextInt();
//            List<int[]> res = new ArrayList<>();
//            for (int i = 0; i < N; i++) {
//                int[] tmp = new int[2];
//                tmp[0] = scanner.nextInt();
//                tmp[1] = scanner.nextInt();
//                res.add(tmp);
//            }
//            if (N == 0) {
//                System.out.println(0);
//                continue;
//            }
//            Comparator<int[]> comparator = new Comparator<int[]>() {
//                @Override
//                public int compare(int[] o1, int[] o2) {
//                    return o2[0] - o1[0] + o2[1] - o1[1];
//                }
//            };
//            Collections.sort(res, comparator);
//            int[] dp = new int[N];
//            dp[0] = 1;
//            for (int i = 1; i < N; i++) {
//                int w = res.get(i)[0];
//                int l = res.get(i)[1];
//                dp[i] = 1;
//                for (int j = 0; j < i; j++) {
//                    if (res.get(j)[0] >= w && res.get(j)[1] >= l) {
//                        dp[i] = Math.max(dp[j] + 1, dp[i]);
//                    }
//                }
//            }
//            int r = 1;
//            for (int i = 0; i < dp.length; i++) {
//                if (dp[i] > r)
//                    r = dp[i];
//            }
//            System.out.println(r);
//        }
//    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for(int i = 0; i < n; i ++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            // 因为 W 都是正数，所以直接做差排序是没问题的。
            Arrays.sort(arr, (e1, e2) -> e1[0] - e2[0]);
            int dp[] = new int [n];
            int index=0;
            for(int i=0;i<n;i++)
            {
                int target=arr[i][1];
                int low=0;
                int high=index;
                while(low<high){
                    int mid=(low+high)>>1;
                    if(dp[mid]>target){
                        high=mid-1;
                    }
                    else{
                        low=mid+1;
                    }
                }
                if(low==index){
                    index++;
                }
                dp[index]=target;
            }
            System.out.println(index);
        }

}
/*
题目描述
小明有一袋子长方形的积木，如果一个积木A的长和宽都不大于另外一个积木B的长和宽，则积木A可以搭在积木B的上面。
好奇的小明特别想知道这一袋子积木最多可以搭多少层，你能帮他想想办法吗？
定义每一个长方形的长L和宽W都为正整数，并且1 <= W <= L <= INT_MAX, 袋子里面长方形的个数为N, 并且 1 <= N <= 1000000.
假如袋子里共有5个积木分别为 (2, 2), (2, 4), (3, 3), (2, 5), (4, 5), 则不难判断这些积木最多可以搭成4层,
因为(2, 2) < (2, 4) < (2, 5) < (4, 5)。
输入描述:
第一行为积木的总个数 N
之后一共有N行，分别对应于每一个积木的宽W和长L
输出描述:
输出总共可以搭的层数
示例1
输入
5
2 2
2 4
3 3
2 5
4 5
输出
4
 */