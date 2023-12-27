public class Task27{
	public boolean task(int [][] array) { 
		for (int i = 0; i < array.length; i++) {
			boolean flag = true;
			for (int j = 0; j < (array[i]).length; j++) {
				if (array[i][j]%3!=0) {
					flag=false;
					break;
				}
			}
			if (flag == true) {
				return true;
			}
		}
		return false;
	}
}