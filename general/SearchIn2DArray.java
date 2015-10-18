import java.util.Arrays;

public class SearchIn2DArray {
	/*
	 * start with the top right element. if equal return. if less, element must
	 * be in next row. if greater, element must be in next column. Returns an
	 * array containing the index of the element returns null if element is not
	 * found. O(N) time.
	 */
	public static int[] search(int[][] a, int num) {
		int i = 0;
		int j = a[0].length - 1;
		while (i < a[0].length && j >= 0) {
			if (a[i][j] == num)
				return new int[] { i, j };
			else if (a[i][j] > num)
				j--;
			else if (a[i][j] < num)
				i++;
		}
		return null;
	}

	/*
	 * Treat 2D array as a 1D array and do binary search.
	 */
	public static int[] binarySearch(int[][] a, int key) {
		int N = a[0].length;
		int lo = 0;
		int hi = N * N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (compare(key, mid, a) < 0)
				hi = mid - 1;
			else if (compare(key, mid, a) > 0)
				lo = mid + 1;
			else {
				return new int[] { mid / N, mid % N };
			}
		}
		return null;
	}

	/*
	 * helper functions which convers 1d indices to 2d indices and compares
	 */
	private static int compare(int key, int i, int[][] a) {
		int N = a[0].length;
		int row = i / N;
		int col = i % N;
		return (key - a[row][col]);
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		System.out.println(Arrays.toString(search(a, 15)));
		System.out.println(Arrays.toString(binarySearch(a, 15)));
	}

}
