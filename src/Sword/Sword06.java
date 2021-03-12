package Sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sword06 {
    public int[] reversePrint(ListNode head) {
        dfs(head);

        int tmp[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            tmp[i] = res.get(i);
        return tmp;
    }

    List<Integer> res = new ArrayList();

    public void dfs(ListNode curr) {
        if (curr == null) {
            return;
        }
        dfs(curr.next);
        res.add(curr.val);
    }
}
