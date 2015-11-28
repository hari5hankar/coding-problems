
public class FactorialTrailingZeroes {

	public static int trailingZeroes(int n) {
		int count = 0;
		for(int i = 5; i <= n; i = i += 5){
			int j= i;
			while(j % 5 == 0){
				count++;
				j /= 5;
			}
		}
		return count;
	}
	
	public static int trailing(int n){
			int count = 0;
			for(long i = 5; i <= n; i *= 5){
				count += n / i;
				System.out.println(count + " " + i);
			}
			return count;
	}
	
	public static void main(String[] args) {
		System.out.println(trailing(2147483647));
		
	}
}
