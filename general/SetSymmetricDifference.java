import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SetSymmetricDifference {

	public static int[] symmetric(int[] a, int[] b){
		List<Integer> list = new ArrayList<>();
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int i = 0, j = 0;
		while(i < a.length && j < b.length){
			if(a[i] < b[j])
				list.add(a[i++]);
			else if(a[i] > b[j])
				list.add(b[j++]);
			else{
				int p = a[i];
				int q = b[j];
				while(a[++i] == p);
				while(b[++j] == q);
			}
		}
		
		while(i < a.length){
			list.add(a[i++]);
		}
		
		while(j < b.length){
			list.add(b[j++]);
		}
		
		int[] ret = new int[list.size()];
		for(int k = 0; k < ret.length; k++){
			ret[k] = list.get(k);
		}
		return ret;
			
	}
	
	
	public static String[] symmetricDifference(String[] a, String[] b){
		HashSet<String> setA = new HashSet<>();
		for(String s : a){
			setA.add(s);
		}
		
		for(String s : b){
			if(setA.contains(s))
				setA.remove(s);
		}
		String[] ret = new String[setA.size()];
		return setA.toArray(ret);
		
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 2, 2, 4};
		int[] b = {2, 2, 3, 3, 7, 15};
		int[] c = symmetric(a, b);
		System.out.println(Arrays.toString(c));
	}
}
