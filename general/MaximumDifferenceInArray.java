/*
 * Given an array arr[] of integers, find out the difference between any two elements such that larger element appears after the smaller number in arr[].
 */
public class MaximumDifferenceInArray {

	public static int maxDiff(int arr[]) {
		int arr_size = arr.length;
		int max_diff =0;
		int i, j;
		for (i = 0; i < arr_size; i++) {
			for (j = i + 1; j < arr_size; j++) {
				if (arr[j] - arr[i] > max_diff)
					max_diff = arr[j] - arr[i];
			}
		}
		return max_diff;
	}

	public static void main(String[] args) {
		//int arr[] = {2, 3, 10, 6, 4, 8, 1};
		int arr[] = {9, 7, 5, 6, 3, 2 };
		System.out.println("Maximum difference is " + maxDiff(arr));
	}

}
