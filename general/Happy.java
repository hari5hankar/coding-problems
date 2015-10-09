import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Happy {
	
	public static void read() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("PracticeInputf.txt"));
		String s = null;
		while ((s = br.readLine()) != null) {
			happy(Integer.parseInt(s));
		}
		br.close();
	}

	public static void happy(int num){
		List<Integer> list = new ArrayList<>();
		int ans = num;
		boolean unhappy = false;
		while(ans !=1){
			list.add(ans);
			ans = sumOfSquares(ans);
			if(list.contains(ans)){
				unhappy= true;
				break;
			}
		}
		if(unhappy){
			System.out.print("unhappy ");
		}else{
			System.out.print("happy ");
		}
		System.out.println(list.size());
	}
	
	
	private static int sumOfSquares(int num){
		int sum = 0;
		while (num != 0) {
            int digit = num % 10;
			sum += digit * digit;
            num /= 10;
      }
		return sum;
	}
	
	
	
	public static void main(String[] args) {
		try {
			read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
