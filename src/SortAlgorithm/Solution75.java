package SortAlgorithm;

public class Solution75 {
    public void sortColors(int[] nums) {
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == 1) {
                int tmp = nums[p1];
                nums[p1] = nums[i];
                nums[i] = tmp;
                p1++;
            } else if (nums[i] == 0) {
                int tmp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = tmp;
                if (p0 < p1) {
                    tmp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = tmp;
                }
                p0++;
                p1++;
            }
        }
    }
}
/*
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
注意：请不要使用代码库中的排序函数来解决这道题。
进阶：
    你能想出一个仅使用常数空间的一趟扫描算法吗？
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-colors
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

