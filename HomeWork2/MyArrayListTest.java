package HomeWork2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    MyArrayList<Integer> mock = new MyArrayList<>();

    @BeforeEach
    public void setUp(){
        mock.add(1);
        mock.add(27);
        mock.add(100);
    }
    @AfterEach
    public void tearDown(){
        mock = new MyArrayList<>();
    }

    @Test
    void testRemove() {
        mock.remove(1);
        assertEquals(mock.size(), 2);
        assertFalse(mock.contains(1));
    }
    @Test
    void testAdd() {
        mock.add(100);
        assertTrue(mock.contains(100));
        assertEquals(mock.get(3), 100);
    }
    @Test
    void testSize(){ assertEquals(3, mock.size()); }
    @Test
    void testGet() {
        assertEquals(mock.get(0), 1);
    }
    @Test
    void testContains() {
        assertTrue(mock.contains(1));
    }
}