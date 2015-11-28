import java.util.Arrays;

public class RotateArray {

	public static void rotate(int[] nums, int k) {

		if (nums == null || k < 0)
			return;
		k = k % nums.length;
		int pivot = nums.length - k;
		reverse(nums, 0, pivot - 1);
		reverse(nums, pivot, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}

	private static void reverse(int[] nums, int lo, int hi) {
		int i = lo, j = hi;
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(nums, 6);
		System.out.println(Arrays.toString(nums));
	}
}
