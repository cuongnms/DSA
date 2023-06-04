package sort;

public class QuickSelect {
    public int partition(int[] arr, int low, int high){
        // select last value as pivot.
        int pivotValue = arr[high];

        // set pivot index to first index of array
        int pivotIndex = low;

        // compare all value with pivot value. If less than pivot then swap that value with value at pivot index.
        for(int i = low; i <=high; i++){
            if(arr[i] < pivotValue){
                int temp = arr[i];
                arr[i] = arr[pivotIndex];
                arr[pivotIndex] = temp;
                pivotIndex++;
            }
        }

        int temp = arr[high];
        arr[high] = arr[pivotIndex];
        arr[pivotIndex] = temp;
        return pivotIndex;
    }

    public int kSmallestElement(int[] arr, int low, int high, int k){
        // find the partition
        int partition = partition(arr, low, high);

        // if partition value is equal to the kth position,
        // return value at k.
        if (partition == k - 1)
            return arr[partition];

            // if partition value is less than kth position,
            // search right side of the array.
        else if (partition < k - 1)
            return kSmallestElement(arr, partition + 1, high, k);

            // if partition value is more than kth position,
            // search left side of the array.
        else
            return kSmallestElement(arr, low, partition - 1, k);
    }

    public static void main(String[] args) {
        QuickSelect q = new QuickSelect();
        int[] array = new int[] { 1, 4, 5, 8, 6 };
        int[] arraycopy
                = new int[] { 1, 4, 5, 8, 6};

        int kPosition = 3;
        int length = array.length;

        if (kPosition > length) {
            System.out.println("Index out of bound");
        }
        else {
            // find kth smallest value
            System.out.println(
                    "K-th smallest element in array : "
                            + q.kSmallestElement(arraycopy, 0, length - 1,
                            kPosition));
        }
    }
}
