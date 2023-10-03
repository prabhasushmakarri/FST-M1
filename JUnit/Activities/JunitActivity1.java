package Activities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JunitActivity1 {
    static ArrayList<String> list;
    @BeforeEach
    void setUp() {
        list = new ArrayList<String>();
        list.add("alpha");
        list.add("beta");
    }
    @Test
    public void insertTest() {

        assertEquals(2, list.size(), "Wrong size");
        list.add(2, "sushma");
        assertEquals(3, list.size(), "Wrong size");
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("beta", list.get(1), "Wrong element");
        assertEquals("sushma", list.get(2), "Wrong element");
    }
    @Test
    public void replaceTest() {

        list.set(1, "sushma");

        // Assert size of list
        assertEquals(2, list.size(), "Wrong size");
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("sushma", list.get(1), "Wrong element");
    }


}
