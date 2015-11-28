import java.util.ArrayList;
import java.util.List;

public class HappyNumber {

	public static boolean happy(int num){
		List<Integer> list = new ArrayList<>();
		boolean unhappy = false;
		while(num !=1){
			list.add(num);
			num = sumOfSquares(num);
			if(list.contains(num)){
				unhappy= true;
				break;
			}
		}
		return !unhappy;
	}

	private static int sumOfSquares(int num){
		int sum = 0;
		while (num != 0) {
            int digit = num % 10;
			sum += digit * digit;
            num /= 10;
      }
		return sum;
	}
	
}
