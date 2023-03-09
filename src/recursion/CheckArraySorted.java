package recursion;

public class CheckArraySorted {
    public boolean checkArraySorted(int[] array, int n){
        if(n==1){
            return true;
        }
        if(array[n-1] < array[n-2]){
            return false;
        }else{
            return checkArraySorted(array, n-1);
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,6,2};
        CheckArraySorted checkArraySorted = new CheckArraySorted();
        System.out.println(checkArraySorted.checkArraySorted(array, 5));
    }
}
