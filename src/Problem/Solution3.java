package Problem;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char tmp[] = s.toCharArray();
        int l = tmp.length;
        int dp[] = new int[l];
        dp[0] = 1;
        for (int i = 1; i < l; i++) {
            int flag = 0;
            for (int j = i - dp[i - 1]; j < i; j++) {
                if (tmp[j] == tmp[i]) {
                    dp[i] = i - j;
                    flag = 1;
                }
            }
            if (flag == 0) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int max = dp[0];
        for (int i = 1; i < l; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution3 t=new Solution3();
        System.out.println(t.lengthOfLongestSubstring(""));
    }
}

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//        示例 1:
//
//        输入: "abcabcbb"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//        示例 2:
//
//        输入: "bbbbb"
//        输出: 1
//        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//        示例 3:
//
//        输入: "pwwkew"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。