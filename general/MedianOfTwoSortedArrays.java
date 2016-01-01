public class MedianOfTwoSortedArrays{
	
	public double medianOfTwoSortedArrays(int[] a, int[] b){
		if (a == null || b == null) return 0;

		int i = 0, j = 0, k = 0; 
		while (k <= ((a.length + b.length) / 2)) {
			if (i == a.length){
				k++;
				j++;
			}
			else if (j == b.length){
				k++;
				i++;
			}
			else if (a[i] < b[j]){
				k++;
				i++;
			}
			else{
				k++;
				j++;
			}
		}

		//TODO
		return 0.0;
	}
}