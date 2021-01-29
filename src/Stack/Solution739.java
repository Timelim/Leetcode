package Stack;

import java.util.Arrays;
import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        int res[]=new int[T.length];
        if(T.length==0)
            return res;
        Arrays.fill(res,0);
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<T.length;i++)
        {
            int top=stack.peek();

            while (T[i]>T[top]){
                res[top]=i-top;
                stack.pop();
                if(stack.empty())
                    break;
                top=stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

}
/*
请根据每日 气温 列表，重新生成一个列表。
对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/daily-temperatures
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */