import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] nums) {
		
		if(nums.length <= 1) return nums.length;
		
		int i = 1;
		int j = 0;
		for(i = 1; i < nums.length; i++){
			if(nums[i] != nums[j])
				nums[++j] = nums[i];
		}
/*		while( i < nums.length){
			if(nums[i] == nums[j])
				i++;
			else
				nums[++j] = nums[i++];
		}*/
		return j + 1;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 3, 4, 5, 5, 5, 6};
		System.out.println(Arrays.toString(nums) + "\n");
		System.out.println(removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
		
		
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for(int i = 0; i < 100000; i++){
			map.put(i, i);
		}
		
		for(int i : map.keySet()){
			System.out.println(i);
		}
	}
}
