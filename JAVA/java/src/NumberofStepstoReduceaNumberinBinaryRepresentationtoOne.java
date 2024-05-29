public class NumberofStepstoReduceaNumberinBinaryRepresentationtoOne {
    public int numSteps(String s) {
        int N = s.length();

        int operations = 0;
        int carry = 0;
        for (int i = N - 1; i > 0; i--) {
            int digit = Character.getNumericValue(s.charAt(i)) + carry;

            if (digit % 2 == 1) {
                operations += 2;
                carry = 1;
            } else {
                operations++;
            }
        }

        return operations + carry;
    }

    public static void main(String[] args) {
        NumberofStepstoReduceaNumberinBinaryRepresentationtoOne ob=new NumberofStepstoReduceaNumberinBinaryRepresentationtoOne();
        System.out.println(ob.numSteps("1101"));
    }
}
