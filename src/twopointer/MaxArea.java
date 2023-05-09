package twopointer;

public class MaxArea {
    public int maxArea(int[] height) {
        int result = 0;
        int firstIndex = 0;
        int lastIndex = height.length-1;
        for(;firstIndex < lastIndex;){
            int v = Math.abs(lastIndex-firstIndex)*Math.min(height[firstIndex], height[lastIndex]);
            if(v > result){
                result = v;
            }
            if(height[firstIndex] < height[lastIndex]){
                firstIndex++;
            }else{
                lastIndex--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxArea m = new MaxArea();
        System.out.println(m.maxArea(new int[]{1,8,100,2,100,4,8,3,7}));
    }
}
