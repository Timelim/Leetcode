package Problem;

public class Solution1299 {

    public int[] replaceElements(int[] arr) {
        int l = arr.length;
        int max = getMax(arr, 0);
        for (int i = 0; i < l - 1; i++) {
            if (arr[i] != max)
                arr[i] = max;
            else {
                max = getMax(arr, i + 1);
                arr[i]=max;
            }
        }
        arr[l-1]=-1;
//        for (int i=0;i<l;i++)
//            System.out.println(arr[i]);
        return arr;
    }

    public int getMax(int[] arr, int start) {
        int l = arr.length;
        int res = arr[start];
        for (int i = start; i < l; i++)
            if (arr[i] > res)
                res = arr[i];
        return res;
    }

    public static void main(String[] args) {
        Solution1299 t = new Solution1299();
        t.replaceElements(new int[]{17});

    }
}
/*
给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
完成所有替换操作后，请你返回这个数组。
示例：
输入：arr = [17,18,5,4,6,1]
输出：[18,6,6,6,1,-1]
提示：
1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */