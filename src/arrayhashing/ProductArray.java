package arrayhashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProductArray {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        int[] right = new int[nums.length];
        right[right.length-1] = 1;
        for(int i = 1 ; i < nums.length; i++){
            left[i] = left[i-1]*nums[i-1];
        }
        for(int i = nums.length - 2; i >=0; i--){
            right[i] = right[i+1] * nums[i+1];
        }
        for(int i = 0 ; i < right.length; i++){
            right[i] = left[i]*right[i];
        }
        return right;
    }

    public static void main(String[] args) {
        ProductArray p = new ProductArray();
        p.productExceptSelf(new int[]{-1,1,0,-3,3});
    }
}
// 1 1 2 2*3
// 3*4 4 1 1
