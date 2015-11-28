import java.util.ArrayList;
import java.util.List;

public class Pascal {

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<>();

		if (numRows == 0)
			return list;

		ArrayList<Integer> one = new ArrayList<>(1);
		one.add(1);
		list.add(one);

		if (numRows == 1)
			return list;

		ArrayList<Integer> two = new ArrayList<>(2);
		two.add(1);
		two.add(1);
		list.add(two);

		if (numRows == 2)
			return list;

		generate(numRows, 3, list);
		return list;
	}

	private static void generate(int numRows, int currentRow, List<List<Integer>> list) {
		if (currentRow > numRows)
			return;

		ArrayList<Integer> currRow = new ArrayList<>(currentRow);
		currRow.add(1);
		List<Integer> prevRow = list.get(currentRow - 2);
		for (int i = 0; i < prevRow.size() - 1; i++) {
			currRow.add(prevRow.get(i) + prevRow.get(i + 1));
		}
		currRow.add(1);

		list.add(currRow);
		generate(numRows, currentRow + 1, list);
	}

	public static void main(String[] args) {
		List<List<Integer>> list = generate(0);
		for (List<Integer> l : list) {
			System.out.println(l.toString());
		}
	}

}
