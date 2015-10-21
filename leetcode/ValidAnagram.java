import java.util.HashMap;

public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(char c : s.toCharArray()){
			if(map.containsKey(c)){
				map.put(c, map.get(c) + 1);
			}else{
				map.put(c, 1);
			}
		}
		
		for(char c : t.toCharArray()){
			if(map.containsKey(c)){
				map.put(c, map.get(c) - 1);
				if(map.get(c) == 0)
					map.remove(c);
			}else{
				return false;
			}
		}
		
		if(map.isEmpty()) return true;
		else return false;
    }
}
