import java.util.Arrays;
import java.util.Comparator;

public class SortVersionNumbers {

	public static String[] sort(String[] a) {

		class VersionComparator implements Comparator<String> {

			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				String[] a1 = s1.split("\\.");
				String[] a2 = s2.split("\\.");

				int p1 = 0, p2 = 0;
				while (p1 < a1.length && p2 < a2.length) {
					int i1 = Integer.parseInt(a1[p1]);
					int i2 = Integer.parseInt(a2[p2]);

					if (i1 > i2)
						return 1;
					else if (i2 > i1)
						return -1;
					p1++;
					p2++;
					continue;		
				}
				
				if(p1 > a1.length) return -1;
				else if (p2 > a2.length) return 1;
				else return 0;
			}

		}
		
		Arrays.sort(a, new VersionComparator());
		return a;
	}

	public static void main(String[] args) {
		String[] array = { "1.9", "1.10", "1.1", "1.1.5", "12.0", "1.23", "12.3" };
		System.out.println(Arrays.toString(array));
		String[] ret = sort(array);
		System.out.println(Arrays.toString(ret));
	}

}
