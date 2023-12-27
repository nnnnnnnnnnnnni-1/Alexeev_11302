public class Task29{
	public boolean even(char x){
        return (x=='0' || x=='2' || x=='4' || x=='6' || x=='8');
    }
	public boolean task(int[][] array){ 
        for (int i = 0; i<array.length; i++){
	    boolean check = false;
            for (int j = 0; j < array[i].length; j++){
                String a = "" + array[i][j];
                int k = 0;
                for (int p = 0; p < a.length(); p++){
                    if (even(a.charAt(p))){
                        k++;
                    }
                }
                if (a.length() == k){
                    check = true;
                    break;
                }
            }
            if (ch == false){
                return false;
            }
        }
        return true;
    }
}