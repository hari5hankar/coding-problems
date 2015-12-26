import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (!checkRow(i, board))
				return false;
			if (!checkCol(i, board))
				return false;
		}

		for (int i = 0; i < board.length; i += 3) {
			for (int j = 0; j < board.length; j += 3) {
				if (!checkBox(i, j, board))
					return false;
			}
		}

		return true;

	}

	private  boolean checkRow(int k, char[][] board) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			char x = board[k][i];
			if (x == '.')
				continue;
			if (set.contains(x))
				return false;
			else
				set.add(x);
		}
		return true;
	}

	private  boolean checkCol(int k, char[][] board) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < board[0].length; i++) {
			char x = board[i][k];
			if (x == '.')
				continue;
			if (set.contains(x))
				return false;
			else
				set.add(x);
		}
		return true;

	}

	private  boolean checkBox(int i, int j, char[][] board) {
		Set<Character> set = new HashSet<>();
		for (int p = i; p < i + 3; p++) {
			for (int q = j; q < j + 3; q++) {
				char x = board[p][q];
				if (x == '.')
					continue;
				if (set.contains(x))
					return false;
				else
					set.add(x);
			}
		}
		return true;
	}

	public  void main(String[] args) {
		char[][] board = { ".87654321".toCharArray(), "2........".toCharArray(), "3........".toCharArray(),
				"4........".toCharArray(), "5........".toCharArray(), "6........".toCharArray(),
				"7........".toCharArray(), "8........".toCharArray(), "9........".toCharArray() };
		System.out.println(Arrays.deepToString(board));
		System.out.println(isValidSudoku(board));

	}
}
