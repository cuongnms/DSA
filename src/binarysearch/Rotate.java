package binarysearch;

public class Rotate {
    public int findMin(int[] nums) {
        if(nums.length == 2){
            return Math.min(nums[0], nums[1]);
        }
        int first = 0;
        int last = nums.length-1;
        int mid = 0;
        while(first < last){
            mid = first + (last-first)/2;
            if(mid > 0 && nums[mid] < nums[mid-1]){
                return nums[mid];
            }
            if(nums[mid] >= nums[first] && nums[mid] > nums[last]){
                first = mid + 1;
            }else{
                last = mid - 1;
            }
        }
        return nums[first];
    }

    public static void main(String[] args) {
        Rotate r = new Rotate();
        System.out.println(r.findMin(new int[]{1,2,3,4,5,6}));
    }
}
