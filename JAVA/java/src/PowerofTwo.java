public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {

        return n > 0 && (n & n - 1) == 0;

    }

    public static void main(String[] args) {
        PowerofTwo ob=new PowerofTwo();
        System.out.println(ob.isPowerOfTwo(16));
    }
}
