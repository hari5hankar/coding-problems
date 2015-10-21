
public class ExcelSheetColumnNumber {

	 public static int titleToNumber(String s) {
	 
		 int num = 0;
		 char[] array = s.toCharArray();
		 for(int i = 0; i < array.length; i++){
			 num += (charToNum(array[i]))*(Math.pow(26, array.length - i - 1));
		 }
		 return num;
	 }
	 
	 private static int charToNum(char c){
		 return c - 'A' + 1;
	 }
	 public static void main(String[] args) {
		System.out.println(titleToNumber("Z"));
	}
}
