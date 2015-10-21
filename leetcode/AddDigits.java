
public class AddDigits {

	public static int addDigits(int num) {
		if(num < 10) return num;
		
		int sum = 0;
		while(num !=0){
			sum += num % 10;
			num = num / 10;
		}
		
		return addDigits(sum);
    }
	
	public static int addDigits2(int num){
		if(num == 0) return 0;
		
		if(num % 9 == 0) return 9;
		return (num % 9);
	}
	
	public static void main(String[] args) {
		System.out.println(addDigits2(38));
	}
}
