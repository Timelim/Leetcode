package Sword;

public class Sword29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int res[] = new int[matrix.length * matrix[0].length];
        for (int i = 0; i < res.length; ) {
            for (int j = left; j <= right; j++) {
                res[i++] = matrix[up][j];
            }
            up += 1;

            for (int j = up; j <= down; j++)
                res[i++] = matrix[j][right];
            right -= 1;

            if (i == res.length)
                break;
            for (int j = right; j >= left; j--) {
                res[i++] = matrix[down][j];
            }
            down -= 1;
            for (int j = down; j >= up; j--) {
                res[i++] = matrix[j][left];
            }
            left += 1;
//            System.out.println(up);
//            System.out.println(down);
//            System.out.println(left);
//            System.out.println(right);

        }
        for (int k = 0; k < res.length; k++)
            System.out.printf("%d ", res[k]);
        return res;
    }

    public static void main(String[] args) {
        Sword29 t = new Sword29();
        t.spiralOrder(new int[][]{
                new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}, new int[]{9, 10, 11, 12}
        });
    }
}
/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
示例 1：
[1,2,3,6,9,8,3,2,0]
输入：matrix = [[1,2,3],
               [4,5,6],
               [7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],
               [5,6,7,8],
               [9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
