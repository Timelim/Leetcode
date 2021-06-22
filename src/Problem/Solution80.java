package Problem;

public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; ) {
            int key = nums[i];
            int count = 1;
            int j;
            for (j = i + 1; j < nums.length; j++) {
                if (nums[j] == key)
                    count += 1;
                else break;
            }
            if (count >= 2) {
                nums[index++] = key;
                nums[index++] = key;
            } else nums[index++] = key;
            i = j;
        }
        return index;
    }
}

/*
给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */