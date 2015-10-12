import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.FaultAction;

public class MajorityElement {

	/*
	 * Solution 1: Two loops, inner loop finds if outer element is in majority
	 * by maintaining a count. O(n^2) time. O(1) space.
	 */

	public static int majority_1(int[] a) {
		for (int j = 0; j < a.length; j++) {
			int count = 0;
			for (int k = 0; k < a.length; k++) {
				if (a[k] == a[j])
					count++;
				if (count > a.length / 2)
					return a[k];
			}
		}
		return -1;

	}

	/*
	 * Solution 2: HashMap<Element, IntegerCount>. One pas through array. At any
	 * instant if IntegerCount >= n/2 stop and return. O(n) time O(n) space
	 */

	public static int majority_2(int[] a) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			if (map.get(a[i]) == null) {
				map.put(a[i], 1);
			} else {
				map.put(a[i], map.get(a[i]) + 1);
			}
			if (map.get(a[i]) > a.length / 2)
				return a[i];
		}
		return -1;
	}

	/*
	 * Solution 3: Sort the array. If a majority exists, it must be the median,
	 * as it occurs greater than n/2 times. O(nlogn) time. O(1) space.
	 */

	public static int majority_3(int[] a) {
		Arrays.sort(a);
		int candidate = a[a.length / 2];
		return verifyMajority(candidate, a) ? candidate : -1;
	}

	/*
	 * Solution 4: Moore's voting algorithm. Step 1: find candidate. Step 2:
	 * verify candidate.
	 */

	public static int moore(int[] a) {
		int candidate = findCandidate(a);
		return verifyMajority(candidate, a) ? candidate : -1;
	}

	/*
	 * Returns the candidate majority element Initially: index of majority
	 * element (maj) = 0, count = 1; loop through the array. everytime a[maj] ==
	 * a[i], increment count (vote for), else decrement count (vote against). if
	 * at anytime count == 0, change maj to current element i. If there is a
	 * majority, this would be set as the major element after the first pass.
	 * 
	 * Proof: If there is a majority element 'e', then e's count would be
	 * atleast N/2+1 and other elements can not bring this count to zero by
	 * voting against it. Hence this would be set as the major element after the
	 * first pass.
	 */
	private static int findCandidate(int[] a) {
		int maj = 0; // majority index
		int count = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[maj] == a[i]) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				maj = i;
				count = 1;
			}
		}
		return a[maj];
	}

	// returns true if candidate occurs > n/2 times in array.
	private static boolean verifyMajority(int candidate, int[] a) {
		int c = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == candidate)
				c++;
		}
		return c > (a.length / 2);
	}

	public static void main(String[] args) {
		int a[] = { 3, 3, 4, 4, 2, 4, 2, 4, 4 };
		int b[] = { 3, 3, 4, 2, 4, 4, 2, 4 };
		System.out.println(majority_1(a));
		System.out.println(majority_1(b));

		System.out.println(majority_2(a));
		System.out.println(majority_2(b));

		System.out.println(majority_3(a));
		System.out.println(majority_3(b));

		System.out.println(moore(a));
		System.out.println(moore(b));
	}
}
