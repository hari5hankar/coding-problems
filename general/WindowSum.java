import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WindowSum {

	public static void main(String[] args) {

		Integer[] arr = { 4, 2, 73, 11, -5 };
		ArrayList<Integer> arrList = new ArrayList<Integer>(Arrays.asList(arr));

		System.out.println(calculateWindowSum2(arrList, 2).toString());

	}

	private static ArrayList<Integer> calculateWindowSum(ArrayList<Integer> arrList, int w) {

		if (w == 1)
			return arrList;

		ArrayList<Integer> result = new ArrayList<>();

		int currentSum = 0;
		for (int i = 0; i < w && i < arrList.size(); i++) {
			currentSum = currentSum + arrList.get(i);
		}

		result.add(currentSum);

		for (int i = w; i < arrList.size(); i++) {
			currentSum += arrList.get(i) - arrList.get(i - w);
			result.add(currentSum);
		}

		return result;
	}
	
	
	private static ArrayList<Integer> calculateWindowSum2(ArrayList<Integer> arrList, int w) {

		if (w == 1)
			return arrList;

		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 0; (arrList.size() - 1) >  (i + w - 1) && i < arrList.size(); i++){
			int sum = 0;
			for(int j = i; j < i + w; j++){
				sum += arrList.get(j);
			}
			result.add(sum);
			System.out.println(i);
		}

		return result;
	}
}