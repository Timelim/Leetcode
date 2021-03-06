package bd;

import java.util.Arrays;
import java.util.Scanner;

public class bd1 {
    //直接解答 解决60%，然后超时
    public void main1() {
        int []visit = new int[1000 + 1];
        int n;
        Scanner cin = new Scanner(System.in);

        n = cin.nextInt();
        int pi[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pi[i] = cin.nextInt();
        }
        Arrays.fill(visit, 0);
        visit[1] = 1;
        int curr = 1;
        int count = 0;
        while (curr != n + 1) {
            if (visit[curr] % 2 == 0) {
                curr += 1;
            } else {
                curr = pi[curr];
            }
            count += 1;
            visit[curr] += 1;
            count %= 1000000007;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int dp[] = new int[1000 + 2];
        int n;

        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            n = cin.nextInt();
            int pi[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                pi[i] = cin.nextInt();
            }
            int count = 0;
            Arrays.fill(dp, 0);
            for (int i = 2; i <= n + 1; i++) {
                dp[i] = (dp[i - 1] * 2 % 1000000007 - dp[pi[i - 1]] + 2) % 1000000007;
            }
            System.out.println(dp[n + 1]);
        }
    }
}
/*
存在n+1个房间，每个房间依次为房间1 2 3...i，每个房间都存在一个传送门，i房间的传送门可以把人传送到房间pi(1<=pi<=i),
现在路人甲从房间1开始出发(当前房间1即第一次访问)，每次移动他有两种移动策略：
    A. 如果访问过当前房间 i 偶数次，那么下一次移动到房间i+1；
    B. 如果访问过当前房间 i 奇数次，那么移动到房间pi；
现在路人甲想知道移动到房间n+1一共需要多少次移动；
输入描述:
第一行包括一个数字n(30%数据1<=n<=100，100%数据 1<=n<=1000)，表示房间的数量，接下来一行存在n个数字 pi(1<=pi<=i), pi表示从房间i可以传送到房间pi。
输出描述:
输出一行数字，表示最终移动的次数，最终结果需要对1000000007 (10e9 + 7) 取模。
示例1
输入
复制
2
1 2
输出
4
说明
开始从房间1 只访问一次所以只能跳到p1即 房间1， 之后采用策略A跳到房间2，
房间2这时访问了一次因此采用策略B跳到房间2，之后采用策略A跳到房间3，因此到达房间3需要 4 步操作。
 */