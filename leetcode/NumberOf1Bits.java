public class NumberOf1Bits {

	public static int hammingWeight(int n) {
		long num = n;
		
		int count = 0;
		while(num!=0){
        	count += num & 1;
        	num = num>>1;
        }
		return count;
    }
	
	public static void main(String[] args) {
		
		System.out.println(hammingWeight(33));
	}
}
