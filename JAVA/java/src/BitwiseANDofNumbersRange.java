public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        return right==left?left:rangeBitwiseAnd(left>>1 , right>>1)<<1;
    }

    public static void main(String[] args) {
        BitwiseANDofNumbersRange ob = new BitwiseANDofNumbersRange();
        System.out.println(ob.rangeBitwiseAnd(5,7));
    }
}
