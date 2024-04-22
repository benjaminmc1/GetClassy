import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product p;

    @BeforeEach
    void setUp() {
        p = new Product("Cheerios", "Mini Round pieces of wheat", "000001", 2.99);
    }

    @Test
    void setName() {
        p.setName("Skittles");
        assertEquals("Skittles", p.getName());
    }

    @Test
    void setDescription() {
        p.setDescription("Taste the Rainbow");
        assertEquals("Taste the Rainbow", p.getDescription());
    }

    @Test
    void setCost() {
        p.setCost(1.99);
        assertEquals(1.99, p.getCost());
    }
}