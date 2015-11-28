
public class ReverseInteger {
	public static int reverse(int x) {

		int num = x;
		int rev = 0;
		while (num != 0) {
			if (Integer.MAX_VALUE / 10 < rev || Integer.MIN_VALUE / 10 > rev)
				return 0;
			int rem = num % 10;
			rev = rev * 10 + rem;
			num = num / 10;
		}
		return rev;
	}
	
	public static void main(String[] args) {
		System.out.println(reverse(Integer.MIN_VALUE / 100));
	}
}
