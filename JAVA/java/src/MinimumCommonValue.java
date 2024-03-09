public class MinimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        int first = 0;
        int second = 0;

        // Traverse through both arrays with two pointers
        // Increment the pointer with a smaller value at that index
        // Return the first common element found
        while (first < nums1.length && second < nums2.length) {
            if (nums1[first] < nums2[second]) {
                first++;
            } else if (nums1[first] > nums2[second]) {
                second++;
            } else {
                return nums1[first];
            }
        }

        // Return -1 if there are no common elements
        return -1;
    }

    public static void main(String[] args) {
        MinimumCommonValue ob=new MinimumCommonValue();
        System.out.println(ob.getCommon(new int[] {1,2,3,4,5},new int[] {5,7,8,9}));
    }
}
