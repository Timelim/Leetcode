package Problem;

public class Solution33 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len==0)return -1;
        if(len==1)return nums[0]==target?0:-1;
        int low=0,high=len-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<nums[high]) {
                if(nums[mid]<target &&nums[high]>=target)
                    low=mid+1;
                else high=mid-1;
            }
            else {
                if(nums[low]<=target &&nums[mid]>target)
                    high=mid-1;
                else
                    low=mid+1;
            }
        }
        return -1;
    }
}


