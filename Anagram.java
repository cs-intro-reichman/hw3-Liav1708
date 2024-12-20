/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		//System.out.println(isAnagram("silent","listen"));  // true
		//System.out.println(isAnagram("William Shakespeare","I am a weakish spelle")); // true
		//System.out.println(isAnagram("Madam Curie","Radium came")); // true
		//System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemor")); // true
		
		// Tests the preProcess function.
		//System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		//System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		randomAnagram("tttlll");

		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		// 10 can be changed to much larger values, like 1000
		//for (int i = 0; i < 10; i++) {
		//	String randomAnagram = randomAnagram(str);
		//	System.out.println(randomAnagram);
		//	pass = pass && isAnagram(str, randomAnagram);
		//	if (!pass) break;
		//}
		//System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		boolean checker = false;
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		String checkString = "";
		String checkString2 = "";
		for(int i = 'a'; i < 'z';i++){
			for(int j = 0; j < str1.length(); j++){
				if (str1.charAt(j) == i) {
					checkString += i;
				}
			}
			for(int j = 0; j < str2.length(); j++){
				if (str2.charAt(j) == i) {
					checkString2 += i;
				}
			}
		}		
		if (checkString.equals(checkString2)){
			checker =true;
		}

		return checker;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		

		String newStr = "";
		for(int i = 0; i < str.length(); i++){

			if ((str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122) || str.charAt(i) == ' '){

				newStr += str.charAt(i);
			}
		}
		newStr = newStr.toLowerCase();
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		
		str = preProcess(str);
		String newStr = "";
		for(int i = 'a'; i < 'z';i++){
			for(int j = 0; j < str.length(); j++){
				if (str.charAt(j) == i) {
					newStr += str.charAt(j);
				}
			}
		}

		char[] chars = new char[newStr.length()];
		int random = 0;
		boolean loop = true;
		for(int i = 0; i< newStr.length(); i++){
			chars[i] = newStr.charAt(i);
		}
		int length = newStr.length();
		newStr = "";
		for(int i = 0;i<length; i++){
			while(loop){
				random = (int) (Math.random() * length);
				if(chars[random] != ' '){
					newStr += chars[random];
					chars[random] = ' ';
					loop = false;
				}
			}
			loop = true;
		}




		return newStr;
	}
}
