package Java_Gry_wojenne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoldierTest {

    @Test
    public void testCreateSoldier() {
        // Valid args
        assertEquals("szeregowy", new Soldier(1).getTitle());
        assertEquals("kapral", new Soldier(2).getTitle());
        assertEquals("kapitan", new Soldier(3).getTitle());
        assertEquals("major", new Soldier(4).getTitle());

        // Invalid args
        IllegalArgumentException exceptionOf0 = assertThrows(IllegalArgumentException.class, () -> {
            new Soldier(0);
        });
        assertEquals("Level must be between 1 and 4.", exceptionOf0.getMessage());
        IllegalArgumentException exceptionOf5 = assertThrows(IllegalArgumentException.class, () -> {
            new Soldier(5);
        });
        assertEquals("Level must be between 1 and 4.", exceptionOf5.getMessage());
    }

    @Test
    public void test
}