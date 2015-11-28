import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * Examples:
 * 
 * Input: arr[] = {2, 0, 2} Output: 2 Structure is like below | | |_| We can
 * trap 2 units of water in the middle gap.
 * 
 * Input: arr[] = {3, 0, 0, 2, 0, 4} Output: 10 Structure is like below | | | |
 * | | |__|_| We can trap "3*2 units" of water between 3 an 2, "1 unit" on top
 * of bar 2 and "3 units" between 2 and 4. See below diagram also.
 * 
 * Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1] Output: 6 | | || |
 * _|_||_|||||| Trap "1 unit" between first 1 and 2, "4 units" between first 2
 * and 3 and "1 unit" between second last 1 and last 2
 * 
 * @author HarshHarwani
 *
 */
public class TrappingRainWater {

	// An element of array can store water if there are higher bars than itself
	// on left and right.
	public static int getWater(int[] a) {
		int water = 0;
		for (int i = 0; i < a.length; i++) {
			int maxLeft = 0;
			for (int j = 0; j <= i; j++)
				if (a[j] > maxLeft)
					maxLeft = a[j];
			int maxRight = 0;
			for (int j = a.length - 1; j >= i; j--)
				if (a[j] > maxRight)
					maxRight = a[j];
			water += Math.min(maxLeft, maxRight) - a[i];
		}
		return water;
	}

	public static int getTotalWater(int[] a) {
		int[] left = new int[a.length];
		int[] right = new int[a.length];
		int water = 0;
		left[0] = a[0];
		right[a.length - 1] = a[a.length - 1];
		for (int i = 1; i < a.length; i++) {
			left[i] = Math.max(left[i - 1], a[i]);
		}
		for (int i = a.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], a[i]);
		}
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));

		for (int i = 0; i < a.length; i++) {
			water += Math.min(left[i], right[i]) - a[i];
		}

		return water;
	}

	public static void main(String args[]) {
		int a[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(getTotalWater(a));
		System.out.println(getWater(a));
	}
}
