import java.util.*;

public class ReplaceWords {
    public static String replaceWords(List<String> dictionary, String sentence) {
        String[] wordArray = sentence.split(" ");
        Set<String> dictSet = new HashSet<>(dictionary);

        // Replace each word in sentence with the corresponding shortest root
        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = shortestRoot(wordArray[i], dictSet);
        }

        return String.join(" ", wordArray);
    }

    private static String shortestRoot(String word, Set<String> dictSet) {
        // Find the shortest root of the word in the dictionary
        for (int i = 1; i <= word.length(); i++) {
            String root = word.substring(0, i);
            if (dictSet.contains(root)) {
                return root;
            }
        }
        // There is not a corresponding root in the dictionary
        return word;
    }

    public static void main(String[] args) {
        String[] lang={"cat","bat","rat"};
        List<String>languages= Arrays.asList(lang);
        System.out.println(replaceWords(languages, "the cattle was rattled by the battery"));
    }

}
