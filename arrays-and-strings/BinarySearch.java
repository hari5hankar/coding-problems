
public class BinarySearch {
	
	public static int binarySearch(int[] a, int num) {
		int hi = a.length -1;
		int lo = 0;
		while(lo<=hi){
			int mid = lo + (hi - lo)/2;
			if(num < a[mid]) hi = mid -1;
			else if(num > a[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
		
	}
	
	public static int binarySearchRecursive(int[] a, int num) {
		return binarySearchRecursive(a, num, 0, a.length-1);
	}
	
	private static int binarySearchRecursive(int[] a, int num, int lo, int hi){
		if(lo > hi) return -1;
		int mid = lo + (hi - lo)/2;
		if(num < a[mid]) return binarySearchRecursive(a, num, lo, mid - 1);
		if(num > a[mid]) return binarySearchRecursive(a, num, mid + 1, hi);
		return mid;
	}
	
	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println(binarySearch(a, 10));
	}

}
