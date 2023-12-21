package ClassWork2;
//Вариант2
public class Task1 {
    //если нельзя использовать метод contains:
    public boolean checkNumber(char x){
        return x == '0' || x == '1'|| x == '2'|| x == '3'|| x == '4'|| x == '5'|| x == '6'|| x == '7'|| x == '8'|| x == '9';
    }

    public boolean checkLetter(char x){
        return x == 'q'|| x == 'w'|| x == 'e'|| x == 'r'|| x == 't'|| x == 'y'|| x == 'u'|| x == 'i'|| x == 'o'|| x == 'p'|| x == 'a'|| x == 's'||
         x == 'd'|| x == 'f'|| x == 'g'|| x == 'h'|| x == 'j'|| x == 'k'|| x == 'l'|| x == 'z'|| x == 'x'|| x == 'c'|| x == 'v'|| x == 'b'|| x == 'n'
         || x == 'm'|| x == 'Q'|| x == 'W'|| x == 'E'|| x == 'R'|| x == 'T'|| x == 'Y'|| x == 'U'|| x == 'I'|| x == 'O'|| x == 'P'|| x == 'A'|| x == 'S'|| x == 'D'
         || x == 'F'|| x == 'G'|| x == 'H'|| x == 'J'|| x == 'K'|| x == 'L'|| x == 'Z'|| x == 'X'|| x == 'C'|| x == 'V'|| x == 'B'|| x == 'N'|| x == 'M';
    }
    public boolean tack(String[] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            int countL = 0;
            int countN = 0;
            for (int j = 0; j < arr[i].length(); j++){
                if (checkNumber(arr[i].charAt(j))){
                    countN++;
                } else if (checkLetter(arr[i].charAt(j))){
                    countL++;
                }
            }
            if (countN > countL){
                count ++;
            }
            if (count == 3){
                return true;
            }
        }
        return false;
    }
}
