
public class UglyNumber {

	public static boolean isUgly(int num) {
		if (num < 1)
			return false;

		if (num == 1 || num == 2 || num == 3 || num == 5)
			return true;

		while (num % 2 == 0) {
			num /= 2;
		}
		while (num % 3 == 0) {
			num /= 3;
		}
		while (num % 5 == 0) {
			num /= 5;
		}

		if (num == 1)
			return true;

		return false;

	}

	private static boolean isPrime(int n) {
		if (n == 2)
			return true;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPrime(Integer.MAX_VALUE));
		System.out.println(isUgly(Integer.MAX_VALUE));
	}

}
