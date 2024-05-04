import java.util.Arrays;

public class BoatstoSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        int boatCount = 0;
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while(left <= right){
            int sum = people[left] + people[right];
            if(sum <= limit){
                boatCount++;
                left++;
                right--;
            }
            else{
                boatCount++;
                right--;
            }
        }
        return boatCount;
    }

    public static void main(String[] args) {
        BoatstoSavePeople ob=new BoatstoSavePeople();
        System.out.println(ob.numRescueBoats(new int[] {3,5,3,4},5));
    }
}
