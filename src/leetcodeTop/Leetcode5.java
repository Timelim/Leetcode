package leetcodeTop;

public class Leetcode5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        String ans = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; i + j < n; j++) {
                int k = i + j;
                if (i == 0) {
                    dp[j][k] = true;
                } else if (i == 1) {
                    dp[j][k] = (s.charAt(k) == s.charAt(j));
                }
                else{
                    dp[j][k]=dp[j+1][k-1]&&(s.charAt(j)==s.charAt(k));
                }
                if(dp[j][k]&&i+1>ans.length()){
                    ans=s.substring(j,k+1);
                }
            }
        }
        return ans;
    }

}
/*
5. 最长回文子串
给你一个字符串 s，找到 s 中最长的回文子串。
示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：
输入：s = "cbbd"
输出："bb"
示例 3：
输入：s = "a"
输出："a"
示例 4：
输入：s = "ac"
输出："a"
提示：
1 <= s.length <= 1000
s 仅由数字和英文字母（大写和/或小写）组成
 */