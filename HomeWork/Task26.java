public class Task26{
	public boolean task(int [] array) { 
		int k2 = 0;
		int kpol = 0;
		for (int i = 0; i < array.length; i++) {
			String y = String.valueOf(array[i]);
			if (array[i] > 0){
				int kchet = 0;
				kpol += 1;
				for (int j = 0; j < y.length(); j++) {
					if (y.charAt(j) % 2 == 0) {
						kchet += 1;
					}
				}
				if (kchet > 0) {
					k2 +=1;
				}
			}
		}
		if (kpol==k2) {
			return true;
		}
		return false;
	}
}