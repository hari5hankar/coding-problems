import java.util.Arrays;

public class MoveZeroes {

	public static void moveZeroes2(int[] nums) {

		int zero = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				continue;
			}
			if (zero == -1 && nums[i] == 0)
				zero = i;
			while (nums[i] == 0) {
				i++;
			}
			swap(nums, i, zero);
			zero++;
		}
		swap(nums, nums.length - 1, zero);
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void moveZeroes(int[] nums){
		int count = 0;
		for(int i = 0; i <nums.length; i++){
			if(nums[i] != 0) 
				swap(nums, i, count++);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 0, 0, 1, 0, 3, 12 };
		moveZeroes2(nums);
		System.out.println(Arrays.toString(nums));
	}
}
