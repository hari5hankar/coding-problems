import java.io.InputStream;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {

	public static void runningMedian(InputStream inputStream) {

		/*
		 * Use two heaps, one maxHeap and one minHeap, and maintain the
		 * invariant: top of the heaps contain the middle element.
		 */
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

		Scanner sc = new Scanner(inputStream);
		int a = sc.nextInt();
		int b = sc.nextInt();

		// add smaller element to maxpq, larger to minpq
		if (a > b) {
			minPQ.add(a);
			maxPQ.add(b);
		} else {
			minPQ.add(b);
			maxPQ.add(a);
		}
		while (sc.hasNext()) {
			int c = sc.nextInt();

			// if no. is smaller than top of maxpq add to to maxpq, else minpq
			if (c < maxPQ.peek())
				maxPQ.add(c);
			else
				minPQ.add(c);

			// make number elements in both PQs equal (or differ by max of 1)
			balance(minPQ, maxPQ);
			System.out.println(median(minPQ, maxPQ));
		}
		sc.close();

		System.out.println(median(minPQ, maxPQ));
	}

	private static void balance(PriorityQueue<Integer> minPQ, PriorityQueue<Integer> maxPQ) {
		if (minPQ.size() == maxPQ.size())
			return;
		else if (minPQ.size() > maxPQ.size())
			maxPQ.add(minPQ.remove());
		else
			minPQ.add(maxPQ.remove());
	}

	private static double median(PriorityQueue<Integer> minPQ, PriorityQueue<Integer> maxPQ) {
		if (minPQ.size() == maxPQ.size()) {
			return ((minPQ.peek() + maxPQ.peek()) / 2.0);
		} else if (minPQ.size() > maxPQ.size())
			return minPQ.peek();
		else
			return maxPQ.peek();
	}

	public static void main(String[] args) {
		runningMedian(System.in);
	}
}
