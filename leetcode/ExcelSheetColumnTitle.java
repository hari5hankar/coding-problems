

public class ExcelSheetColumnTitle {

	public static String convertToTitle2(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Input is not valid!");
		}

		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			n--;
			char ch = (char) (n % 26 + 'A');
			n /= 26;
			sb.append(ch);
		}

		sb.reverse();
		return sb.toString();
	}

	public static String convertToTitle(int n) {
		int num = n;
		StringBuilder title = new StringBuilder();
		while (num != 0) {
			int rem = num % 26;
			if (rem == 0) {
				title.append('Z');
				num = num / 26 - 1;
			} else {
				title.append(getCharacter(rem));
				num = num / 26;
			}

		}
		return title.reverse().toString();
	}

	public static char getCharacter(int n) {
		return (char) (n + 'A' - 1);
	}

	public static void main(String[] args) {
		System.out.println(getCharacter(0));
	}
}
