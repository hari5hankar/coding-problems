import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class ArrangeNegativeBeforePositive {

	public static void main(String[] args) {

		int[] a = { -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5 };
		shuffle(a);
		System.out.println(Arrays.toString(a));
		arrangeMerge(a);
		System.out.println(Arrays.toString(a));

	}

	private static void shuffle(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			int max = a.length - 1;
			int r = (int) (Math.random() * (max - min + 1)) + min;
			int temp = a[r];
			a[r] = a[i];
			a[i] = temp;
		}
	}

	private static void arrangeInsertion(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < 0 && a[j - 1] >= 0) {
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				} else {
					break;
				}
			}
		}
	}

	private static void arrangeMerge(int[] a) {
		int[] aux = new int[a.length];
		arrangeMerge(a, aux, 0, a.length - 1);
	}

	private static void arrangeMerge(int[] a, int[] aux, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		arrangeMerge(a, aux, lo, mid);
		arrangeMerge(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}

	private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];

		int i = lo, j = mid + 1, k = lo;
		while (k <= hi) {
			if (i > mid)
				a[k++] = aux[j++];
			else if (j > hi)
				a[k++] = aux[i++];
			else if (aux[i] < 0)
				a[k++] = aux[i++];
			else if(aux[j] < 0)
				a[k++] = aux[j++];
			else if(i <= mid)
				a[k++] = aux[i++];
			else if(j <= hi)
				a[k++] = aux[j++];
		}
	}
}

/*
 * 
 * LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(); for(int i = 0; i
 * < 10; i++) map.put(i, i);
 * 
 * System.out.println(map.get(1));
 * 
 * 
 * 
 * int[] a = { 2, 5, 3, 4 }; int[] b = { 5, 1, 2, 7 };
 * 
 * Arrays.sort(a); Arrays.sort(b);
 * 
 * int i = 0, j = 0; while (i < a.length && j < b.length) { if(a[i] < b[j]){
 * System.out.println(a[i++]); }else if(b[j] < a[i]){
 * System.out.println(b[j++]); }else { System.out.println(a[i]); i++; j++; } }
 * 
 * while( i < a.length){ System.out.println(a[i++]); }
 * 
 * while( j < b.length){ System.out.println(b[j++]); }
 */

/*
 * while (true) { if (i >= a.length && j >= b.length) { break; } else if (i >=
 * a.length) { System.out.println(a[j++]); } else if (j >= b.length) {
 * System.out.println(a[i++]); } else if (a[i] < b[j]) {
 * System.out.println(a[i]); i++; } else if (a[i] > b[j]) {
 * System.out.println([j]); j++; } else { i++; j++; } }
 */