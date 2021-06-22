package DFS;

import Sword.Sword29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sword38 {
    List<String> res = new ArrayList<>();
    char tmp[];

    public String[] permutation(String s) {
        tmp = s.toCharArray();
        vis = new boolean[s.length()];
        Arrays.fill(vis,false);
        dfs(tmp, new char[tmp.length], 0);

        return res.toArray(new String[res.size()]);
    }

    boolean vis[];

    public void dfs(char[] s, char[] cur, int index) {
        if (index == s.length) {
            res.add(String.valueOf(cur));
            System.out.println(String.valueOf(cur));
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if (vis[i] == false) {
                vis[i] = true;
                cur[index] = s[i];
                dfs(s, cur, index + 1);
                vis[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Sword38 t=new Sword38();
        t.permutation("abc");
    }
}
