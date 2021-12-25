class Solution {
    public static int search(int[] nums, int target) {
        int n=nums.length;
        int low=0,high=n-1;
        int deg=0;
        while(low<=high)
        {
            if(nums[low]<=nums[high])
            {
                deg=low;
                break;
            }
            int mid=low+(high-low)/2;
            int start=(mid+n-1)%n;
            int end=(mid+1)%n;
            if(nums[mid]<=nums[start]&&nums[mid]<=nums[end])
            {
               deg=mid;
                break;
            }
            else if(nums[low]<=nums[mid])
                low=mid+1;
            else if(nums[mid]<=nums[high])
                high=mid-1;
            System.out.println(low+" "+mid+" "+high);
        }
        System.out.println(deg);
        low=0;high=deg-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        low=deg;high=n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
    }
}