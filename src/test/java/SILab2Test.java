import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;
import java.util.List;

public class SILab2Test {

    @Test
    public void testEveryBranch() {
        RuntimeException exc;
        List<Item> allItems;
        int payment;

        // Test 1
        List<Item> allItems = null;
        payment = 0;
        exc = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems, payment));
        assertTrue(exc.getMessage().contains("allItems list can't be null!"));

        // Test 2
        allItems = new List<Item>();
        payment = 0;
        assertTrue(SILab2.checkCart(allItems, payment));

        // Test 3
        allItems = new List<Item>();
        payment = -1;
        assertFalse(SILab2.checkCart(allItems, payment));

        // Test 4
        allItems = Arrays.asList( new Item(" ", null, 40, 0.5f) );
        payment = 1;
        exc = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems, payment);
        assertTrue(exc.getMessage().contains("No barcode!"));

        // Test 5
        allItems = Arrays.asList( new Item(" ", "012345", 3000, 0.5f) );
        payment = 1;
        assertFalse(SILab2.checkCart(allItems, payment);

        // Test 6
        allItems = Arrays.asList( new Item("Name". "ABC123", 127, 0.5f) );
        payment = 1;
        exc = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems, payment);
        assertTrue(exc.getMessage().contains("Invalid character in item barcode!"));

        // Test 7
        allItems = Arrays.asList( new Item("Name", "098765", 30, -1) );
        payment = 1;
        assertFalse(SILab2.checkCart(allItems, payment);
    }


    @Test
    public void testMultipleCondition() {
        List<Item> allItems;
        int payment;

        // Test 1
        allItems = Arrays.asList( new Item("Name", "012345", 350, 0.5f) );
        payment = 1;
        assertTrue(SILab2.checkCart(allItems, payment);

        // Test 2
        allItems = Arrays.asList( new Item("Name", "012345", 250, 0.5f) );
        payment = 1;
        assertFalse(SILab2.checkCart(allItems, payment);

        // Test 3
        allItems = Arrays.asList( new Item("Name", "012345", 400, 0) );
        payment = 1;
        assertFalse(SILab2.checkCart(allItems, payment);

        // Test 4
        allItems = Arrays.asList( new Item("Name", "123456", 400, 1) );
        payment = 1;
        assertFalse(SILab2.checkCart(allItems, payment);
    }
}