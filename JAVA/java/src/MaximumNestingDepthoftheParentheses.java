public class MaximumNestingDepthoftheParentheses {
    public int maxDepth(String s) {
        int ans = 0;
        int openBrackets = 0;

        for (Character c : s.toCharArray()) {
            if (c == '(') {
                openBrackets++;
            } else if (c == ')') {
                openBrackets--;
            }

            ans = Math.max(ans, openBrackets);
        }

        return ans;
    }

    public static void main(String[] args) {
        MaximumNestingDepthoftheParentheses ob=new MaximumNestingDepthoftheParentheses();
        System.out.println(ob.maxDepth("(1)+((2))+(((3)))"));
    }
}
