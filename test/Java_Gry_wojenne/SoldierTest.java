package Java_Gry_wojenne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoldierTest {

    @Test
    public void testCreateSoldier() {
        // Valid args
        assertEquals(1, new Soldier("szeregowy").getLevel());
        assertEquals(2, new Soldier("kapral").getLevel());
        assertEquals(3, new Soldier("kapitan").getLevel());
        assertEquals(4, new Soldier("major").getLevel());

        // Invalid args
        IllegalArgumentException exceptionOf0 = assertThrows(IllegalArgumentException.class, () -> {
            new Soldier("bandyta");
        });
        assertEquals("Invalid level.", exceptionOf0.getMessage());
        IllegalArgumentException exceptionOf5 = assertThrows(IllegalArgumentException.class, () -> {
            new Soldier("bojownik");
        });
        assertEquals("Invalid level.", exceptionOf5.getMessage());
    }

    @Test
    public void testIsDead() {
        // case 1
        Soldier soldier = new Soldier("kapitan");
        soldier.setExperience(0);
        assertTrue(soldier.isDead());

        // case 2
        Soldier unit = new Soldier("kapral");
        unit.setExperience(4);
        assertFalse(unit.isDead());
    }

    @Test
    public void testPromote() {
        // case 1
        Soldier soldier = new Soldier("szeregowy");
        soldier.setExperience(5);
        soldier.promote();
        assertEquals(2, soldier.getLevel());

        // case 2
        Soldier unit = new Soldier("kapitan");
        soldier.setExperience(14);   // To upgrade unit on level 3 we need 15 experience points or more
        unit.promote();
        assertNotEquals(4, unit.getLevel());
        assertEquals(3, unit.getLevel());
    }
}