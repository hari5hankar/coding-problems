
public class NimGame {

	public static boolean canWinNim(int n) {
		if (n == 4)
			return false;
		
		if (n == 1 || n == 2 || n == 3)
			return true;

		//if any case reduces to non-winnable for my opponent, I can win.
		return !canWinNim(n - 1) || !canWinNim(n - 2) || !canWinNim(n - 3);
	}
	
	public static boolean canWinNim2(int n) {
		return !(n % 4 == 0);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 40; i++) {
			System.out.println(canWinNim2(i + 1));
		}
	}
}
