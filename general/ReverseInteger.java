
public class ReverseInteger {
	public static int reverse(int x) {
		int remainder;
		long reverse = 0;

		if (x == Integer.MIN_VALUE) {
			return 0;
		}

		if (x < 0) {
			return (-1 * reverse(-1 * x));
		}

		while (x != 0) {
			remainder = x % 10;
			reverse = remainder + reverse * 10;
			x = x / 10;
		}

		int answer = (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) ? 0 : (int) reverse;
		return answer;
	}
}
