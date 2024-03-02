public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SquaresofaSortedArray ob = new SquaresofaSortedArray();
        int[] m=ob.sortedSquares(new int[]{0, -1, 5, 7, 10});
        for(int i:m)
        {
            System.out.print(i+" ");
        }
    }
}
