import java.util.Arrays;
import java.util.HashSet;

public class SetSymmetricDifference {

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
		String[] a = { "Desiree Jagger", "Benedict Casteel", "Evon Saddler", "To	     by Greenland", "Norine Caruana",
				"Felecia Houghton", "Lanelle Franzoni", "Armandina Everitt", "Inger Honea", "Autumn Hendriks" };

		String[] b = { "Karrie Rutan", "Desiree Jagger", "Armandina Everitt", "Arlen Nowacki", "Ward Siciliano",
				"Mira Yonts", "Marcelo Arab", "Autumn Hendriks", "Mazie Hemstreet", "Toby Greenland" };
		
		System.out.println(Arrays.toString(symmetricDifference(a, b)));

	}
	

	
	
}
