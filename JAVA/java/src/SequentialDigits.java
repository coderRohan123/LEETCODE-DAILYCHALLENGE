import java.util.ArrayList;
import java.util.List;
public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1;i<=9;i++){
            int first_digit = i;
            int second_digit = i+1;
            while(first_digit<=high && second_digit<=9){
                int num = ( first_digit * 10 ) + second_digit;
                if(num>= low && num <= high){
                    list.add(num);
                }
                first_digit = num;
                second_digit++;
            }
        }
        list.sort(null);
        return list;
    }

    public static void main(String[] args) {
        SequentialDigits ob =new SequentialDigits();
        System.out.println(ob.sequentialDigits(100,300));

    }
}
/*An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.



Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]


Constraints:

10 <= low <= high <= 10^9
 */

