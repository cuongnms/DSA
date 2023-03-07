package Backtracking;

import java.util.Arrays;

public class GenerateKString {
    private int count = 0;
    public static void main(String[] args) {
        GenerateKString g = new GenerateKString();
        g.generateKString(10000, 10,  new int[10000]);
        System.out.println(g.count);
    }

    private void generateKString(int i,int k, int[] ints) {
        if(i<1){
            System.out.println(Arrays.toString(ints));
            count++;
            return;
        }else{
            for(int j = 0; j < k; j++){
                ints[i-1] = j;
                generateKString(i-1, k, ints);
            }
        }
    }
}
