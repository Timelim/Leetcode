package Problem;

import java.util.ArrayList;
import java.util.List;

public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[(nums[i] - 1) % n] += n;
        }
//        for(int i=0;i<n;i++)
//            System.out.println(nums[i]);
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n)
                res.add(i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution448 t = new Solution448();
        System.out.println(t.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
