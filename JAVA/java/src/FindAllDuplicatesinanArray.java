import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {

        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> result = new ArrayList<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int num = Math.abs(nums[i]);
                int idx = num - 1;
                if (nums[idx] < 0)
                    result.add(num);
                nums[idx] *= -1;
            }
            return result;
        }

    public static void main(String[] args) {
        FindAllDuplicatesinanArray  ob= new FindAllDuplicatesinanArray();
        System.out.println(ob.findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
    }
    }

