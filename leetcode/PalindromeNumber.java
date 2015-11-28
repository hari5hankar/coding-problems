
public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
		if (x < 0)
			return false;

		int digits = 0;
		for (int num = x; num > 0; num /= 10)
			digits++;

		int num = x;
		int i = digits - 1;
		int j = 0;
		while (i > j) {
			if (getDigit(num, i--) != getDigit(num, j++))
				return false;
		}
		return true;
	}

	private static int getDigit(int num, int pow) {
		int ret = (num / ((int) Math.pow(10, pow)) % 10);
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(2147483647));
	}
}
