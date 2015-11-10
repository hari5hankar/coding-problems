
public class Solution {

	public static void func(String a){
		
		for(int i = 0; i < a.length(); i++){
			if(a.charAt(i) == '0') continue;
				
			int s = i;
			while(a.charAt(++i) == '1');
			int e = i - 1;
			if(e < s) System.out.println(s + "," + s);
			else System.out.println(s + "," + e);
		}
	}	
	
	public static void main(String[] args) {
		int num =  3 >>> 1;
		int num2 = 3  >> 1;
		System.out.println(num + " "  + num2);
		System.out.println(Integer.toBinaryString(-3));
	}
}
