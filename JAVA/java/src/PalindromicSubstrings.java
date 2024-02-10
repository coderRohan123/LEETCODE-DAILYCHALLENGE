public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            res += extendPalindromes(s, i, i);
            res += extendPalindromes(s, i, i + 1);
        }
        return res;
    }
    private int extendPalindromes(final String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            ++count;
            --l;
            ++r;
        }
        return count;
    }

    public static void main(String[] args) {
        PalindromicSubstrings ob=new PalindromicSubstrings();
        System.out.println(ob.countSubstrings("abc"));
    }
    }
    /*
    Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
     */


