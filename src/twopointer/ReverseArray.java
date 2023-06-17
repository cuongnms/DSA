package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ReverseArray {

    /*
     * Complete the 'performOperations' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. 2D_INTEGER_ARRAY operations
     */

    public static List<Integer> performOperations(List<Integer> arr, List<List<Integer>> operations) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < operations.size(); i++){
            arr = reverserd(arr, operations.get(i));
        }

        return result;
    }

    private static List<Integer> reverserd(List<Integer> arr, List<Integer> operation){
        if(operation.size() != 2){
            return arr;
        }
        if(operation.get(0) < 0 || operation.get(0) > arr.size() - 1 || operation.get(1) < 0 || operation.get(1) > arr.size() - 1){
            return arr;
        }
        int first = operation.get(0);
        int last = operation.get(1);
        for(;first < last;){
            int tmp = arr.get(first);
            arr.set(first, arr.get(last));
            arr.set(last, tmp);
            first++;
            last--;
        }

        return arr;
    }

    public static void main(String[] args) {
        ReverseArray r = new ReverseArray();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
//        list.add(1);
//        list.add(5);
//        list.add(4);
//        list.add(3);
//        list.add(2);
//        list.add(1);
//        list.add(0);

        List<List<Integer>> operations = new ArrayList<>();
        List<Integer> op1= new ArrayList<>();
        op1.add(0);
        op1.add(2);

        List<Integer> op2= new ArrayList<>();
        op2.add(1);
        op2.add(2);

        List<Integer> op3= new ArrayList<>();
        op3.add(0);
        op3.add(2);
//
//        List<Integer> op4= new ArrayList<>();
//        op4.add(2);
//        op4.add(7);
//
//        List<Integer> op5= new ArrayList<>();
//        op5.add(1);
//        op5.add(8);
//
//        List<Integer> op6= new ArrayList<>();
//        op6.add(0);
//        op6.add(9);

        operations.add(op1);

        operations.add(op2);
        operations.add(op3);
//        operations.add(op4);
//        operations.add(op5);
//        operations.add(op6);


        r.performOperations(list, operations);
        System.out.println(Arrays.toString(list.toArray()));
    }

//    public List<Integer> getServerIndex(int n, List<Integer> arrival, List<Integer> burstTime) {
//        // Write your code here
//
//        int[][] sortByArrivalTime = new int[arrival.size()][2];
//        for(int i = 0; i < sortByArrivalTime.length; i++){
//            sortByArrivalTime[i] = new int[]{arrival.get(i), burstTime.get(i)};
//        }
//
//        Arrays.sort(sortByArrivalTime, (a,b) -> Integer.compare(a[0], b[0]));
//        for(int[] a : sortByArrivalTime) {
//            System.out.println(a[0] + " " + a[1]);
//        }
//
//        List<Integer> result = new ArrayList<>();
//
//
//
//        return result;
//
//    }
//
//    public static void main(String[] args) {
//        List<Integer> a = new ArrayList<>();
//        a.add(2);
//        a.add(4);
//        a.add(1);
//        a.add(8);
//        a.add(9);
//        List<Integer> b = new ArrayList<>();
//        b.add(7);
//        b.add(9);
//        b.add(2);
//        b.add(4);
//        b.add(5);
//        Result r = new Result();
//        r.getServerIndex(1, a,b);
//
//
//    }

}