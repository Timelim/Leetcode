package Problem;


import java.util.Arrays;

public class Interview1708 {
    //最长上升子序列
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int a[][] = new int[height.length][2];
        for (int i = 0; i < height.length; i++) {
            a[i][0] = height[i];
            a[i][1] = weight[i];
        }
        //Arrays.sort(arr, (e1, e2) -> e1[0] - e2[0]);
        Arrays.sort(a, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
//        for (int i = 0; i < a.length; i++) {
//            System.out.printf("%d,", a[i][1]);
//        }
        int dp[] = new int[height.length];
        int index = 0;
        for (int i = 0; i < height.length; i++) {
            int t = a[i][1];
            int low = 0, high = index;
            while (low < high) {
                int mid = (low + high) >> 1;
                if (dp[mid] >= t) {
                    high = mid;
                } else if (dp[mid] < t) {
                    low = mid + 1;
                }
            }
            dp[low] = t;
            if (low == index) {
                index += 1;
            }
        }
//        System.out.println("----------");
//        for (int i = 0; i < index; i++)
//            System.out.println(dp[i]);
//        System.out.println(index);
        return index;
    }

    public static void main(String[] args) {
        Interview1708 t = new Interview1708();
        //t.bestSeqAtIndex(new int[]{2868, 5485, 1356, 1306, 6017, 8941, 7535, 4941, 6331, 6181}, new int[]{5042, 3995, 7985, 1651, 5991, 7036, 9391, 428, 7561, 8594});
        t.bestSeqAtIndex(new int[]{8378, 8535, 8998, 3766, 648, 6184, 5506, 5648, 3907, 6773}, new int[]{9644, 849, 3232, 3259, 5229, 314, 5593, 9600, 6695, 4340});
        //[1,2,3,4] [4,3,2,1]
    }
}
/*
[8378,8535,8998,3766,648,6184,5506,5648,3907,6773] [9644,849,3232,3259,5229,314,5593,9600,6695,4340]
[2868,5485,1356,1306,6017,8941,7535,4941,6331,6181]
[5042,3995,7985,1651,5991,7036,9391,428,7561,8594]

有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，
在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，
请编写代码计算叠罗汉最多能叠几个人。
示例：
输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
输出：6
解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/circus-tower-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
