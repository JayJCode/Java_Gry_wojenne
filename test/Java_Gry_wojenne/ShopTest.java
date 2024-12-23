package Java_Gry_wojenne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    public void testCanApply() {
        General player1 = new General();
        Boolean result = player1.shop.canApply(player1, "szeregowy", 5);
        assertEquals(true, result);

        Boolean result2 = player1.shop.canApply(player1, "szeregowy", 6);
        assertEquals(false, result2);
    }

    @Test
    public void  testBuySoldiers() {
        General testPlayer = new General();
        if(testPlayer.shop.canApply(testPlayer, "kapitan", 1)) {
            testPlayer.shop.buySoldiers(testPlayer, "kapitan", 1);
        }
        assertNotEquals(50, testPlayer.getGold());
        assertEquals(20, testPlayer.getGold());

        if(testPlayer.shop.canApply(testPlayer, "szeregowy", 2)) {
            testPlayer.shop.buySoldiers(testPlayer, "szeregowy", 2);
        }
        assertEquals(0, testPlayer.getGold());
    }
}