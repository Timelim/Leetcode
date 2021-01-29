package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//拓扑排序
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int input[] = new int[numCourses];
        int output[] = new int[numCourses];
        int graph[][] = new int[numCourses][numCourses];
        for (int i = 0; i < numCourses; i++)
            Arrays.fill(graph[i], 0);
        for (int i = 0; i < prerequisites.length; i++) {
            output[prerequisites[i][0]] += 1;//出度+1
            input[prerequisites[i][1]] += 1;//入度+1
            graph[prerequisites[i][0]][prerequisites[i][1]] = 1;

        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (input[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int j = 0; j < numCourses; j++) {
                if (graph[node][j] == 1) {
                    input[j] -= 1;
                    if (input[j] == 0)
                        queue.offer(j);
                }
            }
        }
        for(int i=0;i<numCourses;i++)
        {
            if(input[i]!=0)
                return false;
        }
        return true;
    }
}
/*
你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
示例 1:

输入: 2, [[1,0]]
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。

示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。

提示：

    输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
    你可以假定输入的先决条件中没有重复的边。
    1 <= numCourses <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/course-schedule
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */