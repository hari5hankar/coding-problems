import java.util.ArrayList;
import java.util.List;

/*	
 * Given denominations of coins:
 * 1 , 5, 10 , 25, 100
 * find the number of ways a sum can be reached.
 */

public class CoinCombinations {

	public static int getNumberOfCombinations(int sum) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);list.add(5);list.add(10);list.add(25);list.add(100);
		int count = 0;
		
		for(int denomination: list){
			int q = sum / denomination;
			int r = sum % denomination;
			if(r==0) count++;
			else if (q!=0){
				for(int i : list){
					if(i>=denomination) continue;
					if((r% i) == 0) count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(getNumberOfCombinations(25));
	}
}


