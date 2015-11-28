import java.util.Arrays;

public class MergeTwoSortedArrays {

	 public static void merge(int[] nums1, int m, int[] nums2, int n) {
	     
		 int i = m - 1; 
		 int j = n - 1; 
		 int k = m + n - 1;	
		 while(	i >= 0 && j >= 0){
			 if(nums1[i] > nums2[j]){
				 nums1[k--] = nums1[i--];
			 }else if(nums1[i] < nums2[j]){
				 nums1[k--] = nums2[j--];
			 } else{
				 nums1[k--] = nums1[i--];
				 nums1[k--] = nums2[j--];
			 }
		 }
		 
		 while(i >=0){
			 nums1[k--] = nums1[i--];
		 }
		 
		 while(j >=0){
			 nums1[k--] = nums2[j--];
		 }
		 
	 }
	 
	 public static void main(String[] args) {
		int[] nums1 = new int[10];
		int[] nums2 = new int[4];
		for(int i = 0; i < nums1.length; i++){
			nums1[i] = (int) (((Math.random() * 100)) + 1);
			if(i < 4) nums2[i] = (int) ((1 + (Math.random() * 100)) + 1);
		}
		
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums2));
		
		merge(nums1, 6, nums2, 4);
		
		System.out.println(Arrays.toString(nums1));
	}
	
}
