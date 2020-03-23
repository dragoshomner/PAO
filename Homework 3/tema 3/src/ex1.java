import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.util.Scanner;

public class ex1 {

	public static boolean checkAnagrame(HashMap <Character, Integer> hm1,
			HashMap <Character, Integer> hm2) {
		
		for (char letter = 'a'; letter < 'z'; letter++) {
			int valHm1 = hm1.getOrDefault(letter, 0);
			int valHm2 = hm2.getOrDefault(letter, 0);
			
			if (valHm1 != valHm2) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		HashMap<Character, Integer> lettersMap1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> lettersMap2 = new HashMap<Character, Integer>();
		String word1, word2;
		Scanner sc = new Scanner(System.in);
		word1 = sc.nextLine();
		word2 = sc.nextLine();
		
		CharacterIterator it1 = new StringCharacterIterator(word1.toString());
		while (it1.current() != CharacterIterator.DONE) {
			Integer count = lettersMap1.containsKey(it1.current()) ? lettersMap1.get(it1.current()) : 0;
			lettersMap1.put(it1.current(), count + 1);
			it1.next();
		}
		
		CharacterIterator it2 = new StringCharacterIterator(word2.toString());
		while (it2.current() != CharacterIterator.DONE) {
			lettersMap2.merge(it2.current(), 1, (k, v) -> v + 1);
			it2.next();
		}
		
		String result = checkAnagrame(lettersMap1, lettersMap2) ? "Sunt anagrame" : "Nu sunt anagrame";
		System.out.println(result);
		
		sc.close();
	}

}
