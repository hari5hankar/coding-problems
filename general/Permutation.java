public class Permutation{
public static boolean isPermutation(String s1, String s2){
    if (s1.length() != s2.length()) return false;
    int checker = 0;
    for(int i = 0; i < s1.length();i++ ){
        checker ^= s1.charAt(i) ^ s2.charAt(i);
    }

    return checker == 0;
}

public static void main(String[] args) {
	int[] s = {3,3,3,3,1,2,1,2,3};
	int a = 0;
	for (int i=0; i<s.length; i++) {
		a ^= s[i];
	}
	System.out.println(a);
	//System.out.println(isPermutation("abcd", "dcba"));
	//System.out.println(isPermutation("abcd", "dcbc"));	
}	
}
