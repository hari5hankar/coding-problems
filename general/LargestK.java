import java.io.InputStream;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LargestK {

	public static void largestK(int k, InputStream inputStream) {

		PriorityQueue<Integer> minPQ = new PriorityQueue<>(new Comparator<Integer>() {

			// natural order
			public int compare(Integer i1, Integer i2) {
				if (i1 > i2)
					return 1;
				else if (i2 > i1)
					return -1;
				else
					return 0;
			}
		});

		Scanner sc = new Scanner(inputStream);
		while (sc.hasNext()) {
			int i = sc.nextInt();
			minPQ.add(i);
			if (minPQ.size() > k) {
				minPQ.remove();
				System.out.println(minPQ); // print all elements of heap
			}
		}
		sc.close();

		System.out.println(minPQ);
	}

	public static void main(String[] args) {
		largestK(5, System.in);
	}
}
