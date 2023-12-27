public class Task25{

	public boolean checkVowel(char x){
		return x == 'E' || x == 'U' || x == 'I' || x == 'O' || x == 'A' || x == 'Y' || x == 'e' || x == 'u' || x == 'i' || x == 'o' || x == 'a' || x ==  'y';
	}
	public boolean task(String a) { 
		int k = 0;
		for (int i = 0; i < a.length(); i++) {
			if ('a' <= a.charAt(i) && a.charAt(i) <= 'z') {
				if (checkVowel(a.charAt(i))){
					k++;
				}
				if (k > 3) {
					return false;
				}
			}
		}
		if (k == 3) {
			return true;
		}
		return false;
	}
}