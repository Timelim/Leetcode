package Problem;

public class Solution42 {
    public int trap(int[] height) {
        int res = 0;
        int N = height.length;
        if (N <= 1)
            return res;
        int left[] = new int[N];
        int right[] = new int[N];
        left[0] = height[0];

        for (int i = 1; i < N; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        right[N - 1] = height[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        for(int i=1;i<N-1;i++){
            int value=Math.min(left[i-1],right[i+1]);
            if(value>height[i])
                res+=(value-height[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution42 t=new Solution42();
        System.out.println(t.trap(new int[]{4,2,0,3,2,5}));
    }
}
/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
示例 1：

输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：
输入：height = [4,2,0,3,2,5]
输出：9

提示：
n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105
 */