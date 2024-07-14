import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberofAtoms {
    public static String countOfAtoms(String formula) {
        // Regular expression to extract atom, count, (, ), multiplier
        // Every element of parsed will be a quintuple
        String regex = "([A-Z][a-z]*)(\\d*)|(\\()|(\\))(\\d*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(formula);

        // Stack to keep track of the atoms and their counts
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());

        // Parse the formula
        while (matcher.find()) {
            String atom = matcher.group(1);
            String count = matcher.group(2);
            String left = matcher.group(3);
            String right = matcher.group(4);
            String multiplier = matcher.group(5);

            // If atom, add it to the top hashmap
            if (atom != null) {
                stack
                        .peek()
                        .put(
                                atom,
                                stack.peek().getOrDefault(atom, 0) +
                                        (count.isEmpty() ? 1 : Integer.parseInt(count))
                        );
            }
            // If left parenthesis, insert a new hashmap to the stack
            else if (left != null) {
                stack.push(new HashMap<>());
            }
            // If right parenthesis, pop the top element from the stack
            // Multiply the count with the attached multiplicity.
            // Add the count to the current formula
            else if (right != null) {
                Map<String, Integer> currMap = stack.pop();
                if (!multiplier.isEmpty()) {
                    int mult = Integer.parseInt(multiplier);
                    for (String atomName : currMap.keySet()) {
                        currMap.put(atomName, currMap.get(atomName) * mult);
                    }
                }

                for (String atomName : currMap.keySet()) {
                    stack
                            .peek()
                            .put(
                                    atomName,
                                    stack.peek().getOrDefault(atomName, 0) +
                                            currMap.get(atomName)
                            );
                }
            }
        }

        // Sort the final map
        TreeMap<String, Integer> finalMap = new TreeMap<>(stack.peek());

        // Generate the answer string
        StringBuilder ans = new StringBuilder();
        for (String atom : finalMap.keySet()) {
            ans.append(atom);
            if (finalMap.get(atom) > 1) {
                ans.append(finalMap.get(atom));
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(countOfAtoms("Mg(OH)2"));
    }
}
