package Test2variant3;
public class Task1{
    public static void main(String[] args){
        Task1 t = new Task1();
        String[] array = {"ma", "mama", "j", "jjj", "aaaaa", "aaa"};
        System.out.println(t.task(array));
    }
    public boolean prefix (String a, String b){ // строка a - префикс строки b
        if (a.length() > b.length()){
            return false;
        }
        for (int i = 0; i < a.length(); i++){
            if (a.charAt(i) != b.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public boolean task(String[] array){
        int c = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                if (j == i){
                    continue;
                } else {
                    if (prefix(array[i], array[j])){
                        c++;
                    }
                    if (c == 3){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}