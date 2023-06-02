package binarysearch;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int firstIndex = 0;
        int lastIndex = matrix.length * matrix[0].length - 1;
        for(;firstIndex<=lastIndex;){
            int midIndex = firstIndex + (lastIndex-firstIndex)/2;
            // Calculate index of mid value
            int midValue = matrix[midIndex/matrix[0].length][midIndex % matrix[0].length];
            if(midValue == target){
                return true;
            }else if(midValue > target){
                lastIndex = midIndex-1;
            }else{
                firstIndex = midIndex+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix s = new SearchMatrix();
        System.out.println(s.searchMatrix(new int[][]{{1,2,4,5},{7,8,9,11},{14,16,17,18}}, 7));
    }
}
