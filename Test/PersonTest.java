import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person p;
    @BeforeEach
    void setUp() {
        p = new Person("000001", "Benjamin", "McKee", "Mr.", 2004);
    }

    @Test
    void testSetFirstName() {
        p.setFirstName("John");
        assertEquals("John", p.getFirstName());
    }

    @Test
    void testSetLastName() {
        p.setLastName("Doe");
        assertEquals("Doe", p.getLastName());
    }

    @Test
    void testSetTitle() {
        p.setTitle("Mr.");
        assertEquals("Mr.", p.getTitle());
    }

    @Test
    void testSetYOB() {
        p.setYOB(1999);
        assertEquals(1999, p.getYOB());
    }

    @Test
    void testFullName() {
        p.setFirstName("John");
        p.setLastName("Doe");
        p.fullName();
        assertEquals("John Doe", p.fullName());
    }

    @Test
    void testFormalName() {
        p.setFirstName("John");
        p.setLastName("Doe");
        p.fullName();
        p.setTitle("Mr.");
        assertEquals("Mr. John Doe", p.formalName());
    }

    @Test
    void testGetAge() {
        assertEquals(20, p.getAge());
    }

    @Test
    void testGetAge1() {
        assertEquals(20, p.getAge(2024));
    }
}
