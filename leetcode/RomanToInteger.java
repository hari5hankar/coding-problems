import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanToInteger {
	public static int romanToInt(String s) {
		Map<Character, Integer> map = new LinkedHashMap<>();

		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int ans = 0;

		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() - 1 && map.get(s.charAt(i + 1)) > map.get(s.charAt(i))) {
				ans += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
				i++;
			} else {
				ans += map.get(s.charAt(i));
			}
		}
		return ans;

	}

	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCVI"));
		// "MCMXCVI"
	}
}
