package recursion;

public class TowerOfHanoi {
    /*
    - Move top n-1 disks from source to mid using des as the middle rod then move the remain disk to des
    - Move again n-1 disk from mid to des
     */
    public void towerOfHanoi(int n, String source, String mid, String des){
        if(n==0) return;
        if(n==1){
            System.out.println("Move disk 1 from "+ source + " to " + des);
            return;
        }
        towerOfHanoi(n-1, source, des, mid);
        System.out.println("Move disk " + n + " from " + source + " to " + des);
        towerOfHanoi(n-1, mid, source, des);

    }

    public static void main(String[] args) {
        TowerOfHanoi t = new TowerOfHanoi();
        t.towerOfHanoi(4, "SOURCE", "MID", "DES");
    }
}
