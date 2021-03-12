package Sword;

public class Sword45 {
    public String minNumber(int[] nums) {
        String res = "";
        String tmp[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = String.valueOf(nums[i]);
        }
        fastSort(tmp, 0, tmp.length - 1);
        for (int i = 0; i < tmp.length; i++) {
            res += tmp[i];
        }
        return res;
    }

    public void fastSort(String[] str, int low, int high) {
        if(low>=high)return;
        int l=low,r=high;
        while(l<r){
            while ((str[r]+str[low]).compareTo(str[low]+str[r])>=0&&l<r) r--;
            while ((str[l]+str[low]).compareTo(str[low]+str[l])<=0&&l<r) l++;
            if(l<r){
                String tmp=str[l];
                str[l]=str[r];
                str[r]=tmp;
            }
        }
        String tmp=str[low];
        str[low]=str[l];
        str[l]=tmp;
        fastSort(str,low,l-1);
        fastSort(str,l+1,high);
    }

    public static void main(String[] args) {
        Sword45 s = new Sword45();
        System.out.println(s.minNumber(new int[]{3,30,34,5,9}));
    }
}
