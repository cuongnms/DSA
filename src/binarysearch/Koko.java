package binarysearch;

public class Koko {
    public int minEatingSpeed(int[] piles, int h) {
        int highestSpeed = maxOfPiles(piles);
        int lowestSpeed = 1;
        int speedResult = 0;
        for(;lowestSpeed<=highestSpeed;){
            speedResult = lowestSpeed + (highestSpeed - lowestSpeed)/2;
            if(canEatAll(speedResult, h, piles)){
                highestSpeed = speedResult - 1;
            }else{
                lowestSpeed = speedResult+1;
            }
        }
        return lowestSpeed;
    }

    private boolean canEatAll(int speedResult, int h, int[] piles) {
        int countHour = 0; // Hours take to eat all bananas at speed K.

        for (int pile : piles) {
            countHour += pile / speedResult;
            if (pile % speedResult != 0)
                countHour++;
        }
        return countHour <= h;
    }

    private int maxOfPiles(int[] piles) {
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < piles.length; i++){
            if(piles[i]>= max){
                max = piles[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Koko k = new Koko();
        System.out.println(k.minEatingSpeed(new int[]{30,11,23,4,20}, 5));

    }
}
