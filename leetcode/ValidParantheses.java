import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParantheses {

	public static boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				stack.push(c);
			} else if (map.containsValue(c)) {
				if (!stack.isEmpty() && map.get(stack.peek()) == c)
					stack.pop();
				else
					return false;
			}
		}
		return stack.isEmpty(); 
	}

	public static void main(String[] args) {
		System.out.println(isValid("]"));
	}
}
