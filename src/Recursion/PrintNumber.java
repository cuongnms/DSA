package Recursion;

public class PrintNumber {
    /*
     Print all number from n to 0 using recursion
     */
    public void printNumber(int n){
        if(n==0){
            System.out.println(0);
            return;
        }
        System.out.println(n);
        printNumber(n-1);
    }

    public static void main(String[] args) {
        PrintNumber p = new PrintNumber();
        p.printNumber(10);
    }
}
