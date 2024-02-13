public class FindFirstPalindromicStringintheArray {
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            // Return false if the characters are not the same.
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public String firstPalindrome(String[] words) {
        for (String s : words) {
            if (isPalindrome(s)) {
                return s;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        FindFirstPalindromicStringintheArray ob=new FindFirstPalindromicStringintheArray();
        String[] m={"abc","car","ada","racecar","cool"};
        System.out.print(ob.firstPalindrome(m));
    }
}
