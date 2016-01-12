import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

	/************************************************************
	 * Solution 1: Union Find create a backing array representing each of the
	 * grid points. union each point with neighbouring points (make ids same)
	 * The number of unique ids = number of islands
	 *************************************************************/

	int N, M;

	public int numIslands(char[][] grid) {

		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
			return 0;

		N = grid.length;
		M = grid[0].length;

		int[] uf = new int[N * M];
		int k = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				if (grid[i][j] == '1')
					uf[k] = k;
				else
					uf[k] = -1;
				k++;
			}

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				if (grid[i][j] != '1')
					continue;

				if (i + 1 < N && grid[i + 1][j] == '1')
					union(uf, i, j, i + 1, j);
				if (j + 1 < M && grid[i][j + 1] == '1')
					union(uf, i, j, i, j + 1);
				if (i - 1 >= 0 && grid[i - 1][j] == '1')
					union(uf, i, j, i - 1, j);
				if (j - 1 >= 0 && grid[i][j - 1] == '1')
					union(uf, i, j, i, j - 1);
			}

		HashSet<Integer> islands = new HashSet<>();
		for (int i : uf)
			if (i != -1)
				islands.add(i);
		return islands.size();
	}

	private void union(int[] uf, int si, int sj, int di, int dj) {

		int sid = uf[indexOf(si, sj)];
		int did = uf[indexOf(di, dj)];
		for (int i = 0; i < uf.length; i++)
			if (uf[i] == sid)
				uf[i] = did;
	}

	private int indexOf(int i, int j) {
		return i * M + j;
	}

	/************************************************************
	 * Solution 2: DFS in graph
	 * Recursively "merge" points accessible from a given point
	 *************************************************************/

	 public int numIslands2(char[][] grid) {

			if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
				return 0;

			int N = grid.length;
			int M = grid[0].length;

			int numIslands = 0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++) {
					if (grid[i][j] == '1'){
						dfs(grid, i, j);
						numIslands++;
					}
				}
			
			return numIslands;

		}

		private void dfs(char[][] grid, int i, int j) {
			int N = grid.length;
			int M = grid[0].length;

			grid[i][j] = '0'; //mark as visited
			
			//recursively visit all unmarked adjacent points
			if (i + 1 < N  && grid[i+1][j] == '1')
				dfs(grid, i+1, j);
			if (i - 1 >= 0  && grid[i - 1][j] == '1')
				dfs(grid, i-1, j);
			if (j + 1 < M  && grid[i][j + 1] == '1')
				dfs(grid, i, j+1);
			if (j - 1 >= 0 && grid[i][j-1 ] == '1')
				dfs(grid, i, j-1);
			
		}
		

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };

		char[][] grid2 = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };

		System.out.println(new NumberOfIslands().numIslands2(grid2));
	}

}
