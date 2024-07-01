public class ThreeConsecutiveOdds {
    public static boolean threeConsecutiveOdds(int[] arr) {
        // Loop through the array up to the third-to-last element
        for (int i = 0; i < arr.length - 2; i++) {
            // Check if the current element and the next two elements are all odd
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(threeConsecutiveOdds(new int[] {1,2,3,5,7,9}));
    }
}
