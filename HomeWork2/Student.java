package HomeWork2;

public class Student {
    final private String name;
    final private String surname;
    private int mark;
    public Student(String name, String surname, int mark) {
        if (mark < 0 || mark > 100){
            throw new IllegalArgumentException("Mark is out of bounds");
        }
        this.name = name;
        this.surname = surname;
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString(){
        return surname + " " + mark;
    }
}
