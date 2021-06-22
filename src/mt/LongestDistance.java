package mt;

public class LongestDistance {
    public int getDis(int[] A, int n) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] < min)
                min = A[i];
            else if (A[i] - min > res) {
                res = A[i] - min;
            }
        }
        //System.out.println(min);
        return res;
    }

    public static void main(String[] args) {
        LongestDistance l = new LongestDistance();
        System.out.println(l.getDis(new int[]{10, 5, 11, 4, 2, 5}, 3));
    }
}
/*
有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。

给定数组A及它的大小n，请返回最大差值。

测试样例：
[10,5],2
返回：0
 */