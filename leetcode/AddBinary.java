
public class AddBinary {

	public static String addBinary(String a, String b) {
		if (a == null || a.length() == 0)
			return b;
		if (b == null || b.length() == 0)
			return a;

		StringBuilder A = new StringBuilder(a);
		StringBuilder B = new StringBuilder(b);
		if (A.length() > b.length()) {
			int i = A.length() - B.length();
			while (i-- != 0)
				B.insert(0, "0");
		} else {
			int i = B.length() - A.length();
			while (i-- != 0)
				A.insert(0, "0");
		}

		StringBuilder C = new StringBuilder();
		int sum = 0;
		int carry = 0;
		for (int i = A.length() - 1; i >= 0; i--) {
			int intA = A.charAt(i) == '0' ? 0 : 1;
			int intB = B.charAt(i) == '0' ? 0 : 1;
			sum = (intA + intB + carry) % 2;
			carry = (intA + intB + carry) / 2;
			C.append(sum);
		}

		if (carry != 0)
			C.append(carry);

		return C.reverse().toString();

	}

	public static void main(String[] args) {
		System.out.println(addBinary("111", "111"));

	}
}
