package leetcodeTop;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int dp[] = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            int start = i + 1 - dp[i];
            for (int j = start; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i] -= (j - start + 1);
                }
            }
        }
        int res = dp[0];
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > res)
                res = dp[i];
        }
        return res;
    }

    //hashmap + dp
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = dic.getOrDefault(s.charAt(i), -1);
            dic.put(s.charAt(i), i);
            tmp = tmp < i - index ? tmp+1:i-index;
            res=Math.max(res,tmp);
        }
        return res;
    }
    //滑动窗口
    public int lengthOfLongestSubstring3(String s) {
        Set<Character> set = new HashSet<>();
        int res=0;
        int r=0;
        for(int i=0;i<s.length();i++){
            if(i!=0)
                set.remove(s.charAt(i-1));
            while (r<s.length()&&!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
            }
            res=Math.max(res,r-i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode3 t = new Leetcode3();
        System.out.println(t.lengthOfLongestSubstring(""));
    }
}
/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
示例 4:

输入: s = ""
输出: 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
