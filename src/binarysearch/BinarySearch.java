package binarysearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        if(nums[low]==target){
            return low;
        }else if(nums[high]==target){
            return high;
        }
        while(true){
            if(low == high && nums[low] != target){
                return -1;
            }
            int mid = (low + high)/2;
            if(nums[mid] == target){
                return mid;
            }else{
                if(nums[mid] > target){
                    high = mid;
                }else {
                    low = mid + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        System.out.println(b.search(new int[]{4,5,8,9,10,12,15}, 5));
    }
}
