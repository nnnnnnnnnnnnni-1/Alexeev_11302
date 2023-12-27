public class Task28{
	public boolean checkVowel(char x){
		return x == 'E' || x == 'U' || x == 'I' || x == 'O' || x == 'A' || x == 'Y' || x == 'e' || x == 'u' || x == 'i' || x == 'o' || x == 'a' || x ==  'y';
	}
	public boolean task(String[][] array){
		boolean flag = true;		
		for (int i = 0; i < array[0].length && (flag == true); i++){
			boolean gflag = false;
			for (int j = 0; j < array.length && (gflag == false); j++){
				if (checkVowel(array[j][i].charAt(0))){
					gflag = true;
				}
			}
			flag = gflag;
		}
		return flag;
    }
}