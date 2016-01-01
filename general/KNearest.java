
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KNearest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CPoint newpoint;
		CPoint[] points = new CPoint[10];

		newpoint = new CPoint();

		for (int i = 0; i < 10; i++) {
			newpoint = new CPoint();
			newpoint.x = 9 - i + 0.5;
			newpoint.y = 9 - i + 0.5;
			points[i] = newpoint;
		}
		
		System.out.println(Arrays.toString(points));
		
		System.out.println(Arrays.toString(getKClosestPoints(points, 3)));
		System.out.println(Arrays.toString(getKClosestPoints2(points, 3)));

	}

	public static CPoint[] getKClosestPoints2(CPoint[] points, int k) {

		class ByDistance implements Comparator<CPoint> {
			@Override
			public int compare(CPoint p1, CPoint p2) {
				
				double d1 = Math.sqrt(p1.x * p1.x + p1.y * p1.y);
				double d2 = Math.sqrt(p2.x * p2.x + p2.y * p2.y);

				if (d1 > d2)
					return 1;
				else if (d1 < d2)
					return -1;
				else
					return 0;
			}
		}

		PriorityQueue<CPoint> pq = new PriorityQueue<>(new ByDistance());

		for (CPoint p : points) {
			pq.add(p);
		}
		
		CPoint[] result = new CPoint[k];
		for(int i = 0; i < result.length; i++){
			result[i] = pq.remove();
		}
		return result;
		
	}

	public static CPoint[] getKClosestPoints(CPoint[] points, int k) {
		if (k >= points.length)
			return points;

		if (k < 1)
			return null;

		findKPoints(points, k, 0, points.length - 1);

		CPoint[] result = new CPoint[k];
		int i = 0;
		for (CPoint point : points) {
			// System.out.println(point.x + " " + point.y);
			result[i] = point;
			i++;
			if (i == k)
				break;
		}

		return result;
	}

	private static void findKPoints(CPoint[] points, int k, int start, int end) {
		if (start < end) {
			int pivot = doPartition(points, start, end) - 1;
			if (pivot == k)
				return;
			else {
				if (pivot > k)
					findKPoints(points, k, start, pivot - 1);
				else
					findKPoints(points, k, pivot + 1, end);
			}
		}
	}

	private static int doPartition(CPoint[] points, int start, int end) {
		int left = start;
		int right = end;
		int mid = (left + right) / 2;

		while (left <= right) {
			while (isCurrentPointMinor(points[left], points[mid]))
				left++;

			while (isCurrentPointMinor(points[mid], points[right]))
				right--;

			/*
			 * while(points[left].compareTo(points[mid]) < 0) left++;
			 * 
			 * while(points[mid].compareTo(points[right]) < 0) right--;
			 */
			if (left <= right) {
				swapPoints(points, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private static void swapPoints(CPoint[] points, int left, int right) {

		CPoint temp = points[left];
		points[left] = points[right];
		points[right] = temp;

	}

	private static boolean isCurrentPointMinor(CPoint currentPoint, CPoint nextPoint) {
		double distanceOfCurrentPoint = Math.hypot(currentPoint.x - 0.0, currentPoint.y - 0.0);
		double distanceOfNextPoint = Math.hypot(nextPoint.x - 0.0, nextPoint.y - 0.0);

		if (distanceOfCurrentPoint < distanceOfNextPoint)
			return true;
		else
			return false;
	}

}
