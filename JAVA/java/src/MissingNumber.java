public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        n=(n*(n+1))/2;
        int sum=0;
        for(int s:nums)
            sum+=s;
        return n-sum;

    }

    public static void main(String[] args) {
        MissingNumber ob=new MissingNumber();
        System.out.print(ob.missingNumber(new int[]{3,0,1}));
    }
}
