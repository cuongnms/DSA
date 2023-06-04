package binarysearch;

public class SearchRotate {
    public int search(int[] nums, int target) {
        if(nums.length == 1 && nums[0] == target){
            return 0;
        }

        int high = nums.length - 1;
        int low = 0;
        while(low < high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[low] <= nums[mid]){
                if(target < nums[mid] && target >= nums[low]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else {
                if(target > nums[mid] && target <= nums[high]){
                    low = mid +1;
                }else{
                    high = mid - 1;
                }
            }
        }

        return nums[low] == target ? low : -1;
    }

    public static void main(String[] args) {
        SearchRotate s = new SearchRotate();
        System.out.println(s.search(new int[]{4,6}, 5));
    }
}
