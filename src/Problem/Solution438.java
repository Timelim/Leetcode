package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;
        int num[] = new int[27];
        Arrays.fill(num, 0);
        for (int i = 0; i < p.length(); i++) {
            num[p.charAt(i) - 'a'] += 1;
        }
        int snum[] = new int[27];
        Arrays.fill(snum, 0);
        for (int i = 0; i < p.length(); i++) {
            snum[s.charAt(i) - 'a'] += 1;
        }
        for (int i = p.length(); i  < s.length(); i++) {
            if (Arrays.equals(snum, num)) {
                res.add(i - p.length());
            }
//            System.out.println(i);
//            for(int tmo:snum)
//            System.out.printf("%d ",tmo);
//            System.out.println();
//            for(int tmo:num)
//                System.out.printf("%d ",tmo);
//            System.out.println();
            snum[s.charAt(i) - 'a'] += 1;
            snum[s.charAt(i-p.length()) - 'a'] -= 1;
        }
        if (Arrays.equals(snum, num)) {
            res.add(s.length() - p.length());
        }
//        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        Solution438 s = new Solution438();
        s.findAnagrams("cbaebabacd", "abc");
    }
}
/*
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
示例 1:

输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 示例 2:

输入:
s: "abab" p: "ab"

输出:
[0, 1, 2]

解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */