import java.util.ArrayList;
import java.util.List;

public class Number_of_Laser_Beams_in_a_Bank {
    public int numberOfBeams(String[] bank) {
        ArrayList<Integer> list = new ArrayList<>();

        for(String floor : bank){
            int count = 0;
            for(char ch : floor.toCharArray()){
                if(ch == '1') count++;
            }
            if(0 < count) list.add(count);
        }
        if(list.size() <= 1) return 0;

        int result = 0;
        for(int i = 1; i < list.size(); i++){
            int pre = list.get(i-1);
            int cur = list.get(i);

            result += pre * cur;
        }
        return result;
    }

    public static void main(String[] args)
    {
        Number_of_Laser_Beams_in_a_Bank ob =new Number_of_Laser_Beams_in_a_Bank();
        String a[]={"011001","000000","010100","001000"};
        System.out.println(ob.numberOfBeams(a));
    }
}

/*
'''Input: bank = ["011001","000000","010100","001000"]
   Output: 8
   Explanation: Between each of the following device pairs, there is one beam. In total, there are 8 beams:
    * bank[0][1] -- bank[2][1]
    * bank[0][1] -- bank[2][3]
    * bank[0][2] -- bank[2][1]
    * bank[0][2] -- bank[2][3]
    * bank[0][5] -- bank[2][1]
    * bank[0][5] -- bank[2][3]
    * bank[2][1] -- bank[3][2]
    * bank[2][3] -- bank[3][2]
   Note that there is no beam between any device on the 0th row with any on the 3rd row.
   This is because the 2nd row contains security devices, which breaks the second condition.'''
 */
