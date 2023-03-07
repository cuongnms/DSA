package Backtracking;

import java.util.Arrays;

public class GenerateStringBinary {

    public void generateStringBinary(int n, int[] array){
        if(n < 1){
            System.out.println(Arrays.toString(array));
            return;
        }
        array[n-1] = 0;
        generateStringBinary(n-1, array);
        array[n-1] = 1;
        generateStringBinary(n-1, array);
    }

    public static void main(String[] args) {
        GenerateStringBinary g = new GenerateStringBinary();
        g.generateStringBinary(4, new int[]{0,0,0,0});
    }
}
