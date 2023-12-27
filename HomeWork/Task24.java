public class Task24{
	public boolean task(int [] array) { 
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0){
				k++;
			}
			if (k>=2) {
				return true;
			}
		}
		if (k>=2) {
			return true;
		}
		return false;
	}
}