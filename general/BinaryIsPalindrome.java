public class BinaryIsPalindrome {

	/********************************************************
	 * Solution 1: build a string of bits, check if string is a palindrome.
	 **********************************************************/
	public static boolean isPalindrome_1(int n) {
		String s = IntegerToString(n);
		int len = s.length() - 1;
		for (int i = 0; i <= len / 2; i++) {
			if (s.charAt(i) != s.charAt(len - i))
				return false;
		}
		return true;
	}

	private static String IntegerToString(int n) {
		StringBuilder sb = new StringBuilder();
		int num = n;
		while (num != 0) {
			int rem = num % 2;
			sb.append(Integer.toString(rem));
			num = num / 2;
		}
		return sb.toString();
	}

	/********************************************
	 * Solution 2: check bit by bit: starting with comparing MSB and LSB.
	 ********************************************/
	public static boolean isPalindrome_2(int num) {
		int l = 0, r = 31;
		while (l < r) {
			if (getBit(num, l) != getBit(num, r))
				return false;
			l++;
			r--;
		}
		return true;
	}

	private static boolean getBit(int num, int k) {
		return ((num >>> k) & 1) == 1;
		// return ((1 << k) & num) != 0; //also works
	}

	public static void main(String[] args) {
		int num = 3 << 30;
		num |= 3;
		System.out.println(Integer.toBinaryString(num));
		System.out.println(isPalindrome_2(num));
		System.out.println();
	}
}
