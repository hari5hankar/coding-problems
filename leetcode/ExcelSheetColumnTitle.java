

public class ExcelSheetColumnTitle {

	public static String convertToTitle(int n) {

		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			n--;
			char ch = getCharacter(n);
			sb.append(ch);
			n /= 26;
		}
		
		return sb.reverse().toString();
	}
	
	public static char getCharacter(int n) {
		return (char) (n + 'A');
	}

	public static String convertToTitle2(int n) {
		int num = n;
		StringBuilder title = new StringBuilder();
		while (num != 0) {
			int rem = num % 26;
			if (rem == 0) {
				title.append('Z');
				num = num / 26 - 1;
			} else {
				title.append(getCharacter2(rem));
				num = num / 26;
			}

		}
		return title.reverse().toString();
	}

	public static char getCharacter2(int n) {
		return (char) (n + 'A' - 1);
	}

	public static void main(String[] args) {
		System.out.println(convertToTitle2(26));
		System.out.println(convertToTitle(26));
	}
}
