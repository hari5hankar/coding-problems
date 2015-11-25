
public class ExcelSheetColumnNumber {

	public static int titleToNumber(String s) {

		int num = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int x = charToNum(s.charAt(i));
			num += x * (Math.pow(26, i));
		}
		return num;
	}

	private static int charToNum(char c) {
		return c - 'A' + 1;
	}

	public static void main(String[] args) {
		System.out.println(titleToNumber("ZZ"));
	}
}
