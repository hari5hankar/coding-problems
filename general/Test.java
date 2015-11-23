import java.util.Arrays;
import java.util.HashSet;

public class Test {

	public static void main(String[] args) {
		int[] a = { 2, 5, 3, 4 };
		int[] b = { 5, 1, 2, 7 };

		Arrays.sort(a);
		Arrays.sort(b);

		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
				if(a[i] < b[j]){
					System.out.println(a[i++]);
				}else if(b[j] < a[i]){
					System.out.println(b[j++]);
				}else {
					System.out.println(a[i]);
					i++; j++;
				}
			}
		
		while( i < a.length){
			System.out.println(a[i++]);
		}
		
		while( j < b.length){
			System.out.println(b[j++]);
		}
		
		
		}
}


/*
		while (true) {
			if (i >= a.length && j >= b.length) {
				break;
			} else if (i >= a.length) {
				System.out.println(a[j++]);
			} else if (j >= b.length) {
				System.out.println(a[i++]);
			} else if (a[i] < b[j]) {
				System.out.println(a[i]);
				i++;
			} else if (a[i] > b[j]) {
				System.out.println([j]);
				j++;
			} else {
				i++;
				j++;
			}
		}
*/