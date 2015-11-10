/*
 * A modification of the problem at https://codility.com/demo/results/demoH5GMV3-PV8/
 * https://codility.com/demo/results/demoH5GMV3-PV8/	
 * The length the frog can jump is not constant, but it can jump 
 * any length from (0, D).
 */
public class Frog {

	public static int solution(int[] A, int X, int D) {
		if (X - D <= 0)
			return 0;

		boolean[] leaves = new boolean[X];
		int current = 0;

		for (int i = 0; i < A.length; i++) {
			leaves[A[i]] = true;
			if ((A[i] - current <= X) && (A[i] - current > 0)) {
				current = A[i];
				boolean flag;
				do {
					flag = false;
					for (int j = current + D; j > current && j < X; j--) {
						if (leaves[j]) {
							current = j;
							flag = true;
							break;
						}
					}
					if (X - current <= D) {
						return i;
					}
				} while (flag);
			}
		}

		return -1;
	}

	public static int solution2(int[] A, int X, int D) {
		if (X - D <= 0)
			return 0; // no leaves needed

		boolean leaves[] = new boolean[X];
		leaves[0] = true;
		int pos = 0;
		for (int i = 0; i < A.length; i++) {
			int curr = A[i];
			leaves[curr] = true;
			pos = update(leaves, D, pos);
			if (pos >= (X - D))
				return i;
		}
		return -1;
	}

	private static int update(boolean[] leaves, int D, int max) {
		int ret = max;
		for (int j = max + D; j > max && j < leaves.length; j--) {
			if (leaves[j]) {
				ret = j;
				return update(leaves, D, ret);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int A[] = { 1, 3, 1, 4, 2, 5 };
		System.out.println(solution2(A, 7, 3));
	} 	 

}
