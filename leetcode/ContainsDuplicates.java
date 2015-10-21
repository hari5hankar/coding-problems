import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicates {

	public static boolean containsDuplicate(int[] nums) {

		if (nums.length == 0 || nums == null )
			return false;

		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(nums[i]))
				set.add(nums[i]);
			else
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = new int[10];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i;
		}

		int rand1 = 0, rand2 = 0;
		while (rand1 == rand2) {
			rand1 = (int) (Math.random() * nums.length);
			rand2 = (int) (Math.random() * nums.length);
		}
		System.out.println(rand1 + " " + rand2);
		nums[rand1] = nums[rand2];
		System.out.println(Arrays.toString(nums));
		System.out.println(containsDuplicate(nums));
	}
}
