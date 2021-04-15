package Map.HashMapExample;

import java.util.HashMap;
import java.util.Map;

public class SumOfTwo {
    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,3,4,5};
        int target = 3;
        int[] result = sumOfTwo(numbers,target);
        System.out.println(result[0] + " " + result[1]);
    }
    public static int[] sumOfTwo(int[] numbers, int target){
        Map<Integer,Integer> something = new HashMap<>();
        for (int i = 0; i <numbers.length ; i++) {
            int secondNumber = target - numbers[i];
            if(something.containsKey(secondNumber)){
                return new int[]{i,something.get(secondNumber)};
            }

            something.put(numbers[i], i);
        }
        return new int[]{-1,-1};
    }
}
