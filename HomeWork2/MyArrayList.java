package HomeWork2;
import java.util.Arrays;
public class MyArrayList<T> implements IList<T> {
    private Object [] array;
    private int size;
    public MyArrayList (){
        this.array = new Object[10];
        this.size = 0;
    }
    public void extendCapacity(){
        int newCapacity = array.length * 2;
        array = Arrays.copyOf(array, newCapacity);
    }
    public boolean add(T element){
        if (size == array.length) extendCapacity();
        array[size++] = element;
        return true;
    }
    public void add(int index, T value){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index is iut of bounds");
        }
        size++;
        for (int i = index; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        array[index] = value;
    }
    public T get(int index){
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index is out of bonds");
        }
        return (T)array[index];
    }
    public T getByValue(T value){
        if (this.contains(value)) return value;
        return null;
    }
    public void removeByIndex(int index){
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index is out of bonds");
        }
        for (int i = index; i < size - 1 ; i++){ // сдвигаем элементы влево
            array[i] = array[i + 1];
        }
        array[size] = null;
        size--;
    }
    public boolean remove(T value){
        int indexOfValue = -1;
        for (int i = 0; i < size; i++){
            if (array[i].equals(value)){
                array[i] = null;
                size--;
                indexOfValue = i;
                break;
            }
        }
        if (indexOfValue == -1) return false; // если такой элемент не нашелся то его изначальный индекс не изменился
        for (int i = indexOfValue; i < size - 1; i++){ // сдвигаем элементы влево
            array[i] = array[i + 1];
        }
        return true;
    }
    public boolean contains(T value){
        for (int i = 0; i < size; i++){
            if (array[i].equals(value)){
                return true;
            }
        }
        return false;
    }

    public boolean containsIndex(int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Index is out of bounds");
        return (index <= size) && (array[index] != null);
    }

    public int indexOf(T value) {
        if (value == null){
            for (int i = 0; i < size; i++){
                if (array[i] == null){
                    return i;
                }
            }
        }
        for (int i = 0; i < size; i++){
            if (value.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return false;
    }

    public void print(){
        for (int i = 0; i < size; i++){
            System.out.print(array[i] + " ");
        }
    }
}
