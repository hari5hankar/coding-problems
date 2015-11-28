public class ReverseIntegerBits {
	
    public static int reverseBits(int n) {
    	int r = 0;
    	for(int i = 0; i <= 31; i++){
    		r = (r << 1) | getBit(n, i);
    	}
    	return r;
    }
	
	private static int getBit(int n, int k){
		return ((n >> k) & 1);
	}
	
	public static void main(String[] args) {
		System.out.println(reverseBits(43261596));
	}
}
