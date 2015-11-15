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
	
	// Traverse the array. If element encountered is non-zero, then
    // replace the element at index 'count' with this element
	public static void moveZeroes(int[] nums){
		int count = 0;
		for(int i = 0; i <nums.length; i++){
			if(nums[i] != 0) 
				nums[count++] = nums[i];
		}
		
/*		int j = 0, i = 1;
		while( i < nums.length){
			if(nums[i] == nums[j])
				i++;
			else
				nums[++j] = nums[i++];
		}
		*/
		//Make all elements 0 from count to end.
		while(count < nums.length){
			nums[count++] = 0;
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 0, 0, 1, 0, 3, 12 };
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}
