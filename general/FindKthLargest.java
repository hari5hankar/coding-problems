
public class FindKthLargest {

	public static int select(int[] a, int k) {
		return select(a, k, 0, a.length - 1);
	}

	private static int select(int[] a, int k, int lo, int hi) {
		if (hi <= lo)
			return a[lo];
		int j = partition(a, lo, hi);
		if (j < k) return select(a, k, j + 1, hi);
		else if (j > k) return select(a, k, lo, j - 1);
		else return a[j];
	}

	private static int partition(int[] a, int lo, int hi) {

		int i = lo;
		int j = hi + 1;
		while (true) {

			do {
				i++;
				if (i > hi)
					break;
			} while (a[i] < a[lo]);

			do {
				j--;
				if (j < lo)
					break;
			} while (a[lo] < a[j]);

			if (i >= j)
				break;
			swap(a, i, j);
		}
		swap(a, lo, j);
		return j;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = {7, 5, 3, 4, 8, 1, 9, 2, 6};
		System.out.println(select(a, 0));
	}

}
