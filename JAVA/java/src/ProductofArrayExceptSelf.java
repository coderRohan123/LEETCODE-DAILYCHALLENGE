public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        ProductofArrayExceptSelf ob= new ProductofArrayExceptSelf();
        int m[]=ob.productExceptSelf(new int[] {-1,1,0,-3,3});
        for (int i:m){
            System.out.print(i+" ");
        }

    }
}
