import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Set<Character> characterSet = new HashSet<>();
        int res = 0;

        // Loop over characters in the string
        for (char c : s.toCharArray()) {
            // If set contains the character, match found
            if (characterSet.contains(c)) {
                characterSet.remove(c);
                // add the two occurrences to our palindrome
                res += 2;
            } else {
                // add the character to the set
                characterSet.add(c);
            }
        }

        // if any character remains, we have at least one unmatched
        // character to make the center of an odd length palindrome.
        if (!characterSet.isEmpty()) res++;

        return res;
    }

    public static void main(String[] args) {
        LongestPalindrome ob=new LongestPalindrome();
        System.out.println(ob.longestPalindrome("abccccdd"));
    }
}
