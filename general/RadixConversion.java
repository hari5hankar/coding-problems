import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RadixConversion {

	public static void read() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("PracticeInput_R.txt"));
		String s = null;
		while ((s = br.readLine()) != null) {
			String[] tokens = s.split(",");
			convert(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
		}
		br.close();
	}

	public static void convert(String s, int fromRadix, int toRadix) {
		if (check(s, fromRadix, toRadix) == false) {
			System.out.println("Invalid Input");
		} else {
			System.out.println(convertFromDecimal(convertToDecimal(s, fromRadix), toRadix));
		}
	}

	private static boolean check(String s, int fromRadix, int toRadix) {
		if (fromRadix < 2 || fromRadix > 36) {
			return false;
		}
		if (toRadix < 2 || toRadix > 36) {
			return false;
		}

		char[] ca = s.toCharArray();
		for (char c : ca) {
			int num = Character.getNumericValue(c);
			if (num > fromRadix - 1)
				return false;
		}

		return true;
	}

	public static int convertToDecimal(String num, int fromRadix) {
		char[] input = num.toCharArray();
		int decimal = 0;
		int power = input.length - 1;
		for (char c : input) {
			decimal += Character.getNumericValue(c) * (Math.pow(fromRadix, power--));
		}
		return decimal;
	}

	public static String convertFromDecimal(int num, int toRadix) {
		StringBuffer ans = new StringBuffer();
		if (toRadix == 10)
			return Integer.toString(num);
		else {
			int temp = num;
			while (temp > 0) {
				int rest = temp % toRadix;
				if (rest < 10)
					ans = ans.append(Integer.toString(rest));
				else
					ans = ans.append(Character.forDigit(rest, toRadix));
				temp = temp / toRadix;

			}
		}
		return ans.reverse().toString();
	}

	public static void main(String[] args) {
		try {
			read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
