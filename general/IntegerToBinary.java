
public class IntegerToBinary {

	public static String intToBinary(int x){
		int num = x;
		StringBuilder sb = new StringBuilder();
		while(num != 0){
			int rem = num % 2;
			sb.append(Integer.toString(rem));
			num /= 2;
		}
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(intToBinary(25));
	}
}
