public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int length = 0;

        // We are looking for the last word so let's go backward
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') { // a letter is found so count
                length++;
            } else {  // it's a white space instead
                //  Did we already started to count a word ? Yes so we found the last word
                if (length > 0) return length;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        LengthofLastWord ob=new LengthofLastWord();
        System.out.println(ob.lengthOfLastWord("hi  hidwf   tiger     "));
    }
}
