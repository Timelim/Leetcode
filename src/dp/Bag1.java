package dp;

import java.util.Scanner;

public class Bag1 {
    //��������
    // task��Ϊ��Ʒ��task��Ҫ�ķ���������Ϊ ��Ҫ�ı������� weight��������ļ�����Ϊ��Ʒ�ļ�ֵvalue
    // ����ת��Ϊ�����ڹ̶�������С�ı����� װ��Ʒ���õļ�ֵ���
    //dp[i][j]��i����ǰi����Ʒ��j����������dp[i][j]ֵΪǰi����Ʒ��j���������õ�����ֵ
    // dp[i][j]=Math.max(dp[i-1][j-weight[i]]+value[i],dp[i-1][j])
    public static void main(String[] args) {
        int weight[] = new int[]{0, 20, 30, 50, 30, 50, 30, 40, 10};
        int value[] = new int[]{0, 300, 500, 620, 370, 400, 450, 380, 150};
        int x;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        if (x < 10)
            System.out.println(0);
        int dp[][] = new int[9][x + 1];
        for (int i = 0; i <= x; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= x; j++) {
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i]] + value[i], dp[i - 1][j]);
                } else dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(dp[8][x]);
    }
}
/*
��������
dp[i][j]=dp[i-1][j-weight[i-1]]+value(i-1);
 */
/*
Ⱥ���д����ļ�
�ڽ��д�������������ʱ��ͨ����һ���ϴ�ĵ����������޷�������ļ�����ֳɶ��С�ļ���
Ȼ��һ������С�ļ��ַ�������������Ͻ��д�����ͬ������
�ɲ����ĵ���������ļ��Լ���������������Ҫ�ķ���������������ͬ����������һ�����壬
�����Ҫ�ķ����������������㣬�������޷�ִ�С���������һ���ɶ�̨������ɵļ�Ⱥ��
��ʱ��������������Ҫ���(�ɲ�ִ����С�ļ�����/��Ҫ�ķ�������������
task1:300/20
task2:500/30
task3:620/50
task4:370/30
task5:400/50
task6:450/30
task7:380/40
task8:150/10
���ʼ�Ⱥ�й�x̨������ͨ�����ŵ��ȣ��˼�Ⱥ���һ���Կ���ͬʱ������ٸ�С�ļ���
���������� ��Ⱥ�еĻ���̨��x
��������� ��Ⱥ�ܹ����д�������С�ļ���
ʾ��1�� ���� 10 ��� 150

 */