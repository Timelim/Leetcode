package Problem;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()!=0) {
            dfs(digits, 0, "");
        }
        return res;
    }

    char[][] map = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    public void dfs(String digits, int index, String item) {
        if (index >= digits.length()) {
            res.add(item);
            return;
        }
        int x = digits.charAt(index) - '0' - 2;
        int y_length = map[x].length;
        for (int i = 0; i < y_length; i++) {
            dfs(digits, index + 1, item + map[x][i]);
        }
    }

    public static void main(String[] args) {
        Solution17 t = new Solution17();
        t.dfs("23", 0, "");
        for (String i : t.res) {
            System.out.println(i);
        }
//        System.out.println(t.map[0][1]);
//        System.out.println(t.map[5][3]);
//        System.out.println(t.map[5].length);
    }
}
/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
2-abc 3-def 4-ghi 5-jkl 6-mno 7-pqrs 8-tuv 9-wxyz
示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */