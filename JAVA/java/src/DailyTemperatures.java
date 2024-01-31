import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < n; i++){

            while(!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]){

                int index = stk.pop();

                result[index] = i - index;
            }

            stk.push(i);

        }

        return result;

    }

    public static void main(String[] args) {
        DailyTemperatures ob = new DailyTemperatures();
        int a[]={30,40,50,60};

        int[] j=ob.dailyTemperatures(a);
        System.out.println(j);

    }
}
