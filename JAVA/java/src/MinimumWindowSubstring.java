public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] count = new int[128];
        int required = t.length();
        int left = -1;
        int n = s.length();
        int mini = n + 1;

        for (final char c : t.toCharArray())
            ++count[c];

        for (int l = 0, r = 0; r < n; ++r) {
            if (--count[s.charAt(r)] >= 0)
                --required;
            while (required == 0) {
                if (r - l + 1 < mini) {
                    left = l;
                    mini = r - l + 1;
                }
                if (++count[s.charAt(l++)] > 0)
                    ++required;
            }
        }

        return left == -1 ? "" : s.substring(left, left + mini);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring ob =new MinimumWindowSubstring();
        String s=ob.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
