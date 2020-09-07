import java.util.Arrays;
//未通过
public class Solution910 {
    public int smallestRangeII(int[] A, int K) {
        if (A.length == 1)
            return 0;
        Arrays.sort(A);
        A[0] += K;
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            if (abs(A[i] - min + K) > abs(A[i] - min - K))
                A[i] -= K;
            else {
                A[i] += K;
            }
            min=getMin(A,i);
        }
        Arrays.sort(A);

        return abs(A[A.length-1]-A[0]);
    }

    public int abs(int a) {
        return a > 0 ? a : -a;
    }
    public int getMin(int []A,int index) {
        int min=A[0];
        for(int i=0;i<=index;i++)
            if(A[i]<min)
                min=A[i];
        return min;
    }
    public static void main(String[] args) {
//        System.out.println(A[i]);
    }
}
/*
给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。

在此过程之后，我们得到一些数组 B。

返回 B 的最大值和 B 的最小值之间可能存在的最小差值。

 

示例 1：
输入：A = [1], K = 0
输出：0
解释：B = [1]
示例 2：
输入：A = [0,10], K = 2
输出：6
解释：B = [2,8]
示例 3：
输入：A = [1,3,6], K = 3
输出：3
解释：B = [4,6,3]
提示：
1 <= A.length <= 10000
0 <= A[i] <= 10000
0 <= K <= 10000
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/smallest-range-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */