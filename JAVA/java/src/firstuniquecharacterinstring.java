public class firstuniquecharacterinstring {
    public int firstUniqChar(String s) {
        int res = Integer.MAX_VALUE;
        for (char i = 'a'; i <= 'z'; i++) {
            int index = s.indexOf(i);
            // index == s.lastIndexOf(i) means, this is unique char in the string
            // NOTE: s.lastIndexOf searches from the end of the string, so we need to keep
            // performing this
            // operation through the entire string
            if (index != -1 && index == s.lastIndexOf(i)) {
                res = Math.min(res, index);
            }
        }
        // if res is still max_val, that means, there is no unique char in the string
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        firstuniquecharacterinstring ob =new firstuniquecharacterinstring();
        System.out.println(ob.firstUniqChar("lleetcode"));
    }
}

