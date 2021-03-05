package Sword;

public class Sword53 {
    public int search(int[] nums, int target) {
        int res = 0;
        int low = 0, high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target)
                break;
            else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (low > high)
            return res;
        else {
            for (int i = mid; i < nums.length; i++) {
                if (nums[i] == target)
                    res += 1;
                else {
                    break;
                }
            }
            for (int i = mid - 1; i >= 0; i--) {
                if (nums[i] == target)
                    res += 1;
                else {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Sword53 s= new Sword53();
        System.out.println(s.search(new int[]{1,4},4));
    }
}
