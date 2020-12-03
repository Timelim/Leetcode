package Problem;

import java.util.ArrayList;
import java.util.List;

public class Solution336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j != i) {
                    if(words[j].length()!=0&&words[i].length()!=0) {
                        if ((words[i].charAt(0) != words[j].charAt(words[j].length() - 1)))
                            continue;
                    }
                        if (judge(words[i] + words[j]) == true) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(i);
                        tmp.add(j);
                        res.add(tmp);
                    }
                }
            }
        }
        System.out.println(res);
        return res;
    }

    boolean judge(String str) {
        int len = str.length();
        int low = 0, high = str.length() - 1;
        while (low < high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
            low += 1;
            high -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution336 t = new Solution336();
        t.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
    }
}
