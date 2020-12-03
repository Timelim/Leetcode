package Problem;

public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }
            int num = gas[i] - cost[i];
            int j = 1;
            for (j = 1; j < n; j++) {
                int index = (i + j) % n;
                num = num - cost[index] + gas[index];
                if (num < 0) {
                    break;
                }
            }
            if (j == n)
                return i;
        }
        return -1;
    }
}

//在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//
//        你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
//
//        如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
//
//        说明: 
//
//        如果题目有解，该答案即为唯一答案。
//        输入数组均为非空数组，且长度相同。
//        输入数组中的元素均为非负数。
//        示例 1:
//
//        输入:
//        gas  = [1,2,3,4,5]
//        cost = [3,4,5,1,2]
//
//        输出: 3
//
//        解释:
//        从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
//        开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
//        开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
//        开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
//        开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
//        开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
//        因此，3 可为起始索引。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/gas-station
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。