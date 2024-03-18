package HomeWork2;

import HomeWork2.MyMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
class MyMapTest {
    MyMap<String, Integer> mock = new MyMap<>();

    @BeforeEach
    public void setUp() {
        mock.put("Liverpool", 63);
        mock.put("Manchester city", 62);
        mock.put("Arsenal", 61);
    }

    @AfterEach
    void tearDown() {
        mock = new MyMap<>();
    }

    @Test
    void testPut() {
        mock.put("Aston Villa", 55);
        assertNotNull(mock);
        assertNotNull(mock.get("Aston Villa"));
        assertTrue(mock.containsKey("Aston Villa"));
    }

    @Test
    void testGet(){
        assertNotNull(mock.get("Liverpool"));
        assertEquals(mock.get("Liverpool"), 63);
    }

    @Test
    void testRemove() {
        mock.remove("Manchester city");
        assertNull(mock.get("Manchester city"));
    }

    @Test
    void testContainsKey() {
        assertTrue(mock.containsKey("Liverpool"));
        assertFalse(mock.containsKey("Tottenham"));
    }

    @Test
    void testContainsValue() {
        assertTrue(mock.containsValue(63));
        assertFalse(mock.containsValue(0));
    }
}