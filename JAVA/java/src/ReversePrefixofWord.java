public class ReversePrefixofWord {
    public String reversePrefix(String word, char ch) {
        // Add characters to the result in the original order
        char[] result = word.toCharArray();
        int left = 0;

        for (int right = 0; right < word.length(); right++) {
            // We found ch - reverse characters up to ch by swapping
            if (result[right] == ch) {
                while (left <= right) {
                    swap(result, left, right);
                    left++;
                    right--;
                }
                return new String(result);
            }
        }
        return word;
    }

    private void swap(char[] characters, int index1, int index2) {
        char temp = characters[index2];
        characters[index2] = characters[index1];
        characters[index1] = temp;
    }

    public static void main(String[] args) {
        ReversePrefixofWord ob=new ReversePrefixofWord();
        System.out.println(ob.reversePrefix("abcd",  'z'));
    }
}
